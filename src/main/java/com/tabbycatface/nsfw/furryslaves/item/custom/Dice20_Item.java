package com.tabbycatface.nsfw.furryslaves.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Dice20_Item extends Item {
    public Dice20_Item(Properties properties) {
        super(properties);
    }

    // Adding custom tooltip
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level level, List<Component> components, TooltipFlag p_41424_) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click to roll a random number!").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.literal("Hold SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(p_41421_, level, components, p_41424_);
    }

    // Making it pick a random number on use
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this,14);
        }
        return super.use(level, player, hand);
    }
    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.literal(player.getName()+" rolled "+getRandomNumber()));
    }
    private int getRandomNumber() {
        return (1+RandomSource.createNewThreadLocalInstance().nextInt(20));
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
