package com.tabbycatface.nsfw.furryslaves.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FURRYSLAVES_TAB = new CreativeModeTab("furryslavestab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(ModItems.DICE20.get() );}
    };
}
