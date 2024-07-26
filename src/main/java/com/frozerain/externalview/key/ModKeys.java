package com.frozerain.externalview.key;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
@SideOnly(Side.CLIENT)
public class ModKeys {

    public static KeyBinding ZOOM_OUT = new KeyBinding("key.externalview.zoom_out.description", Keyboard.KEY_PRIOR, "key.externalview.category");
    public static KeyBinding ZOOM_IN = new KeyBinding("key.externalview.zoom_in.description", Keyboard.KEY_NEXT, "key.externalview.category");

    public static KeyBinding TURN_LONG_HAND = new KeyBinding("key.externalview.turn_long_hand", Keyboard.KEY_K, "key.externalview.category");

    public static void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(ZOOM_OUT);
        ClientRegistry.registerKeyBinding(ZOOM_IN);
        ClientRegistry.registerKeyBinding(TURN_LONG_HAND);
    }
}
