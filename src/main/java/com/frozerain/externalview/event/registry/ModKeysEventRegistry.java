package com.frozerain.externalview.event.registry;

import com.frozerain.externalview.key.ModKeys;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ModKeysEventRegistry {
    public static  void preInitialize(FMLPreInitializationEvent ignoredEvent){
        ModKeys.registerKeyBindings();
    }
}
