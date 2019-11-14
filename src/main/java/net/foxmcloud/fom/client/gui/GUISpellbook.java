package net.foxmcloud.fom.client.gui;

import net.minecraft.client.gui.ingame.EditBookScreen;
import net.minecraft.container.LecternContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Hand;

public class GUISpellbook extends EditBookScreen {

	public GUISpellbook(PlayerEntity playerEntity, ItemStack itemStack, Hand hand) {
		super(playerEntity, itemStack, hand);
	}

}
