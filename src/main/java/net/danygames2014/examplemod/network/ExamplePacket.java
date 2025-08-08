package net.danygames2014.examplemod.network;

import net.minecraft.network.NetworkHandler;
import net.minecraft.network.packet.Packet;
import net.modificationstation.stationapi.api.network.packet.ManagedPacket;
import net.modificationstation.stationapi.api.network.packet.PacketType;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ExamplePacket extends Packet implements ManagedPacket<ExamplePacket> {
    public static final PacketType<ExamplePacket> TYPE = PacketType.builder(true, true, ExamplePacket::new).build();

    public ExamplePacket() {
    }

    @Override
    public void read(DataInputStream stream) {
//        stream.
        
    }

    @Override
    public void write(DataOutputStream stream) {

    }

    @Override
    public void apply(NetworkHandler networkHandler) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public @NotNull PacketType<ExamplePacket> getType() {
        return TYPE;
    }
}
