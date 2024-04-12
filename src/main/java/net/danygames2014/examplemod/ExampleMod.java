package net.danygames2014.examplemod;

import net.danygames2014.examplemod.block.ExampleBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

public class ExampleMod {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @Entrypoint.Logger
    public static final Logger LOGGER = Null.get();

    public static Block exampleBlock;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){
        exampleBlock = new ExampleBlock(NAMESPACE.id("example_block"), Material.WOOD).setTranslationKey(NAMESPACE, "example_block");
    }
}
