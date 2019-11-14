package net.foxmcloud.fom;

import org.lwjgl.glfw.GLFW;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.foxmcloud.fom.items.Spellbook;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.registry.Registry;

public class FabricOfMagic implements ModInitializer {

	//Settings
	public static final String MODID = "fom";
	public static final String MOD_NAME = "fabricofmagic";
	public static final String MOD_NAME_FULL = "Fabric of Magic";

	//Network Packet Identifiers
	public static final Identifier KEY_CAST_PACKET = new Identifier(MOD_NAME, "key_cast");

	//Items
	public static final Spellbook SPELLBOOK = new Spellbook(new Item.Settings());

	//Creative Menu
	public static final ItemGroup FOM_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MODID, MOD_NAME)).icon(() -> new ItemStack(SPELLBOOK)).appendItems(stacks -> {
				stacks.add(new ItemStack(SPELLBOOK));
			})
			.build();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "spellbook"), SPELLBOOK);
		ServerSidePacketRegistry.INSTANCE.register(KEY_CAST_PACKET, (packetContext, packetByteBuf) -> {
			ServerPlayerEntity player = (ServerPlayerEntity) packetContext.getPlayer();
			player.addChatMessage(new TextComponent("Casting spell..."), false);
		});
	}
}
