package net.danygames2014.examplemod.item;

import net.danygames2014.examplemod.network.ExamplePacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.network.packet.PacketHelper;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ExampleItem extends TemplateItem {
    public ExampleItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public int getAttackDamage(Entity attackedEntity) {
        return 9001;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (world.isRemote) {
            if (user.isSneaking()) {
                PacketHelper.send(new ExamplePacket(x, y, z, "This is a message sent from client"));
            }
        }
        
        return super.useOnBlock(stack, user, world, x, y, z, side);
    }
}
