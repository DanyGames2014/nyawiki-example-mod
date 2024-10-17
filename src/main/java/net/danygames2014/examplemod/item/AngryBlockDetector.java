package net.danygames2014.examplemod.item;

import net.danygames2014.examplemod.ExampleMod;
import net.danygames2014.examplemod.block.ExampleBlockWithProperty;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class AngryBlockDetector extends TemplateItem {
    public AngryBlockDetector(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity player, World world, int x, int y, int z, int side) {
        BlockState state = world.getBlockState(x, y, z);
        if(state.isOf(ExampleMod.exampleBlockWithProperty)){
            boolean isAngry = state.get(ExampleBlockWithProperty.ANGRY);
            if(isAngry){
                player.sendMessage("The Block do be angry");
            }else {
                player.sendMessage("This block is chill");
            }
            return true;
        }
        return false;
    }
}
