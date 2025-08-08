package net.danygames2014.examplemod.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.NetworkHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.States;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import net.modificationstation.stationapi.api.network.packet.ManagedPacket;
import net.modificationstation.stationapi.api.network.packet.PacketType;
import net.modificationstation.stationapi.api.util.SideUtil;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ExamplePacket extends Packet implements ManagedPacket<ExamplePacket> {
    public static final PacketType<ExamplePacket> TYPE = PacketType.builder(true, true, ExamplePacket::new).build();

    // The fields we are gonna be transferring over the network
    public int x;
    public int y;
    public int z;
    public String message;

    // This is required so the packet can be constructed when received
    public ExamplePacket() {
    }

    // This is how we are gonna initialize the packet before sending it
    public ExamplePacket(int x, int y, int z, String message) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.message = message;
    }

    // This will be called when the packet is received
    @Override
    public void read(DataInputStream stream) {
        try {
            x = stream.readInt();
            y = stream.readInt();
            z = stream.readInt();
            message = stream.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // This will be called when the packet is being sent
    @Override
    public void write(DataOutputStream stream) {
        try {
            stream.writeInt(x);
            stream.writeInt(y);
            stream.writeInt(z);
            stream.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void apply(NetworkHandler networkHandler) {
        SideUtil.run(() -> handleClient(networkHandler), () -> handleServer(networkHandler));
        System.out.println("Message from the client: " + message);
    }

    @Environment(EnvType.CLIENT)
    public void handleClient(NetworkHandler networkHandler) {
        PlayerEntity player = PlayerHelper.getPlayerFromPacketHandler(networkHandler);
        World world = player.world;

        world.setBlockStateWithNotify(x, y, z, States.AIR.get());
        player.sendMessage("Block removed. Hello from Client");
    }

    @Environment(EnvType.SERVER)
    public void handleServer(NetworkHandler networkHandler) {
        PlayerEntity player = PlayerHelper.getPlayerFromPacketHandler(networkHandler);
        World world = player.world;

        world.setBlockStateWithNotify(x, y, z, States.AIR.get());
        player.sendMessage("Block removed. Hello from Server");
    }

    // This will be called after the packet has been written
    @Override
    public int size() {
        return 12 + message.length(); // 4 (int) + 4 (int) + 4 (int) + String Length
    }

    @Override
    public @NotNull PacketType<ExamplePacket> getType() {
        return TYPE;
    }
}
