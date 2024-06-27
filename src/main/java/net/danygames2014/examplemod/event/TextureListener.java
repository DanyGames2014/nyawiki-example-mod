package net.danygames2014.examplemod.event;

import net.danygames2014.examplemod.ExampleMod;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static int exampleBlockTexture;

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ExampleMod.exampleItem.setTexture(NAMESPACE.id("item/example_item"));

        ExpandableAtlas terrainAtlas = Atlases.getTerrain();
        exampleBlockTexture = terrainAtlas.addTexture(NAMESPACE.id("block/example_block")).index;
        ExampleMod.exampleBlock.textureId = exampleBlockTexture;
    }
}
