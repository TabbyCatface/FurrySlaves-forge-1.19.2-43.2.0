package com.tabbycatface.nsfw.furryslaves.item;

import com.tabbycatface.nsfw.furryslaves.FurrySlaves;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FurrySlaves.MOD_ID);





    // Adding items:

    public static final RegistryObject<Item> SILICONE = ITEMS.register("silicone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FURRYSLAVES_TAB)) );






    // Passing the items registry to the mod event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
