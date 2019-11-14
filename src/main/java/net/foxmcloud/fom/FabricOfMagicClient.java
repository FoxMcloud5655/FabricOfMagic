package net.foxmcloud.fom;

import org.lwjgl.glfw.GLFW;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;

public class FabricOfMagicClient implements ClientModInitializer {
	
	//Settings
	public boolean keyCastPressed = false;
	
	//Key Bindings
	private static FabricKeyBinding keyCast = FabricKeyBinding.Builder.create(
			new Identifier(FabricOfMagic.MODID, "cast"), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, FabricOfMagic.MOD_NAME_FULL).build();

	@Override
	public void onInitializeClient() {
		KeyBindingRegistry.INSTANCE.register(keyCast);
		ClientTickCallback.EVENT.register(e -> {
			if (keyCast.isPressed() && !keyCastPressed) {
				keyCastPressed = true;
				ClientSidePacketRegistry.INSTANCE.sendToServer(FabricOfMagic.KEY_CAST_PACKET, new PacketByteBuf(Unpooled.buffer()));
			}
			else if (!keyCast.isPressed() && keyCastPressed) {
				keyCastPressed = false;
			}
		});
	}

}
