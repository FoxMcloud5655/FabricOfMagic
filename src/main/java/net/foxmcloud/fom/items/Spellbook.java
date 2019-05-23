package net.foxmcloud.fom.items;

import java.util.Random;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Spellbook extends Item {
	
	private Random rand = new Random();

	public Spellbook(Settings settings)
	{
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		playerEntity.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F + (rand.nextFloat() / 2));
		return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
	}
}
