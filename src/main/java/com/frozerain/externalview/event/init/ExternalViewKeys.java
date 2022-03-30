package com.frozerain.externalview.event.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ExternalViewKeys {

    public static KeyBinding ZOOM_OUT = new KeyBinding("key.zoom_out.description", Keyboard.KEY_PRIOR, "key.externalview.category");
    public static KeyBinding ZOOM_IN = new KeyBinding("key.zoom_in.description", Keyboard.KEY_NEXT, "key.externalview.category");

    public static void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(ZOOM_OUT);
        ClientRegistry.registerKeyBinding(ZOOM_IN);
    }
}
