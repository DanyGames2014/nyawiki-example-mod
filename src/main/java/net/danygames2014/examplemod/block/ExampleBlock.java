package net.danygames2014.examplemod.block;

import net.danygames2014.examplemod.event.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ExampleBlock extends TemplateBlock {
    public ExampleBlock(Identifier identifier) {
        super(identifier, Material.SAND);
    }

    // Make the block drop 4 sticks
    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return Item.STICK.id;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return 4;
    }

    // Return no collision shape => entities won't collide with it
    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public int getTexture(int side, int meta) {
        if (meta != 0) {
            return 4;
        }

        return switch (side) {
            case 1 -> TextureListener.exampleBlockTexture;
            case 2 -> 1;
            case 3 -> 14;
            default -> 0;
        };
    }
}
