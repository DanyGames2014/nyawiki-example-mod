package net.danygames2014.examplemod.event;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.option.KeyBinding;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import org.lwjgl.input.Keyboard;

public class KeybindListener {
    // A static field holding the keybind so we can read its keycode from anywhere
    public static KeyBinding exampleKeybind;

    @EventListener
    public void registerKeybinds(KeyBindingRegisterEvent event) {
        // Initializing the keybind, the first argument is the translation key and the second is the default keycode
        exampleKeybind = new KeyBinding("key.examplemod.example_keybind", Keyboard.KEY_H);

        // Adding the keybind to the keybindings list
        event.keyBindings.add(exampleKeybind);
    }
}
