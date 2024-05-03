package net.danygames2014.examplemod.event;

import net.danygames2014.examplemod.ExampleMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent.Environment;
import org.lwjgl.input.Keyboard;

public class KeyPressListener {
    @EventListener
    public void handle(KeyStateChangedEvent event) {
        // Only do action if the key was pressed, not when its released
        if (Keyboard.getEventKeyState()) {
            // Check if our keybind has been triggered
            if (Keyboard.isKeyDown(KeybindListener.exampleKeybind.code)) {
                // Perform different actions based on if we are ingame or in gui
                if (event.environment == Environment.IN_GAME) {
                    ExampleMod.LOGGER.info("INGAME");
                } else if (event.environment == Environment.IN_GUI) {
                    ExampleMod.LOGGER.info("INGUI");
                }
            }
        }

        // Check if we are on the correct "side"
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT){
            // Get the game instance and cast it to Minecraft
            Minecraft client = (Minecraft)FabricLoader.getInstance().getGameInstance();

            // Now we can access pretty much anything from the Minecraft main class
            World world = client.world;
            PlayerEntity player = client.player;
        }
    }
}
