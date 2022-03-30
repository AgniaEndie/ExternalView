package com.frozerain.externalview.event;

import com.frozerain.externalview.config.ExternalViewConfig;
import com.frozerain.externalview.event.init.ExternalViewKeys;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ExternalViewEvent {
    public static void preInitialize(FMLPreInitializationEvent event) {
        ExternalViewKeys.registerKeyBindings();
        //ExternalViewConfig.registerConfig(event);

    }
}
