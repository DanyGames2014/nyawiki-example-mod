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
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

public class ExampleMod {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    @Entrypoint.Logger
    public static Logger LOGGER = Null.get();

    // Blocks
    public static Block exampleBlock;
    public static Block exampleBlockWithProperty;
    public static Block exampleLog;

    // Items
    public static Item angryBlockDetector;
    public static Item exampleItem;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        exampleBlock = new ExampleBlock(NAMESPACE.id("example_block")).setTranslationKey(NAMESPACE, "example_block");
        exampleBlockWithProperty = new ExampleBlockWithProperty(NAMESPACE.id("example_block_with_property"), Material.WOOD).setTranslationKey(NAMESPACE, "example_block_with_property");
        exampleLog = new TemplateBlock(NAMESPACE.id("example_log"), Material.WOOD).setTranslationKey(NAMESPACE, "example_log").setSoundGroup(Block.WOOD_SOUND_GROUP).setHardness(0.5F);
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        angryBlockDetector = new AngryBlockDetector(NAMESPACE.id("angry_block_detector")).setTranslationKey(NAMESPACE, "angry_block_detector");
        exampleItem = new ExampleItem(NAMESPACE.id("example_item")).setTranslationKey(NAMESPACE, "example_item");
    }
}
