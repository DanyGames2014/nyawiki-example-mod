package net.danygames2014.examplemod;

import net.danygames2014.examplemod.block.ExampleBlock;
import net.danygames2014.examplemod.block.ExampleBlockWithProperty;
import net.danygames2014.examplemod.item.AngryBlockDetector;
import net.danygames2014.examplemod.item.ExampleItem;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

public class ExampleMod {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @Entrypoint.Logger
    public static final Logger LOGGER = Null.get();

    // Blocks
    public static Block exampleBlock;
    public static Block exampleBlockWithProperty;

    // Items
    public static Item angryBlockDetector;
    public static Item exampleItem;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        exampleBlock = new ExampleBlock(NAMESPACE.id("example_block")).setTranslationKey(NAMESPACE, "example_block");
        exampleBlockWithProperty = new ExampleBlockWithProperty(NAMESPACE.id("example_block_with_proerty"), Material.WOOD).setTranslationKey(NAMESPACE, "example_block_with_property");
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event){
        angryBlockDetector = new AngryBlockDetector(NAMESPACE.id("angry_block_detector")).setTranslationKey(NAMESPACE, "angry_block_detector");
        exampleItem = new ExampleItem(NAMESPACE.id("example_item")).setTranslationKey(NAMESPACE, "example_item");
    }
}
