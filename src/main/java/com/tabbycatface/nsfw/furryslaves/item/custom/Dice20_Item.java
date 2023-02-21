package com.tabbycatface.nsfw.furryslaves.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Dice20_Item extends Item {
    public Dice20_Item(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this,20);
        }
        return super.use(level, player, hand);
    }

    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.literal("You rolled "+getRandomNumber()));
    }
    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(20);
    }

    /**
     * Called when the player Left Clicks (attacks) an entity. Processed before
     * damage is done, if return value is true further processing is canceled and
     * the entity is not attacked.
     *
     * @param stack  The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     default boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {return false;}

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        // Make it capture the feminine rapscallions
        return true;
    }*/
}
