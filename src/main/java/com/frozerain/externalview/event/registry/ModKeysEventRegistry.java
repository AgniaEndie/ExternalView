package com.frozerain.externalview.event.registry;

import com.frozerain.externalview.key.ModKeys;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ModKeysEventRegistry {
    public static  void preInitialize(FMLPreInitializationEvent ignoredEvent){
        ModKeys.registerKeyBindings();
    }
}
