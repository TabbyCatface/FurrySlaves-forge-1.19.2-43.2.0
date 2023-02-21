package com.tabbycatface.nsfw.furryslaves.block;

import com.tabbycatface.nsfw.furryslaves.FurrySlaves;
import com.tabbycatface.nsfw.furryslaves.item.ModCreativeModeTab;
import com.tabbycatface.nsfw.furryslaves.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FurrySlaves.MOD_ID);




    // Adding blocks:

    public static final RegistryObject<Block> SILICONE_BLOCK = registerBlock("silicone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)),
            ModCreativeModeTab.FURRYSLAVES_TAB);

    public static final RegistryObject<Block> RIDGED_ROD = registerBlock("ridged_rod",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)),
            ModCreativeModeTab.FURRYSLAVES_TAB);






    // Two methods extending class "Block" to register a Block and it's respective Item at the same time.
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)) );
    }

    // Passing the blocks registry to the mod event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
