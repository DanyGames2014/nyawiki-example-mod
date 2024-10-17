package net.danygames2014.examplemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.BooleanProperty;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class ExampleBlockWithProperty extends TemplateBlock {

    public static final BooleanProperty ANGRY = BooleanProperty.of("angry");

    public ExampleBlockWithProperty(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ANGRY);
        super.appendProperties(builder);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        if(context.getPlayer().isSneaking()){
            return getDefaultState().with(ANGRY, true);
        }
        return getDefaultState().with(ANGRY, false);
    }
}
