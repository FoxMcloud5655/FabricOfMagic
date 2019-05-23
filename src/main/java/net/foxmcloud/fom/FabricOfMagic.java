package net.foxmcloud.fom;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.foxmcloud.fom.items.Spellbook;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricOfMagic implements ModInitializer {
	
	//Settings
	public static final String MODID = "fom";
	public static final String MOD_NAME = "fabricofmagic";
	public static final String MOD_NAME_FULL = "Fabric of Magic";
	
	//Key Bindings
	private static FabricKeyBinding keyBinding = FabricKeyBinding.Builder.create(
			new Identifier(MODID, "cast"), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, MOD_NAME_FULL).build();
	
	//Items
    public static final Spellbook SPELLBOOK = new Spellbook(new Item.Settings());
    
    //Creative Menu
	public static final ItemGroup FOM_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MODID, MOD_NAME)).icon(() -> new ItemStack(SPELLBOOK))
			.appendItems(stacks ->
			{
				stacks.add(new ItemStack(SPELLBOOK));
			})
			.build();
	
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "spellbook"), SPELLBOOK);
		KeyBindingRegistry.INSTANCE.register(keyBinding);
	}
}
