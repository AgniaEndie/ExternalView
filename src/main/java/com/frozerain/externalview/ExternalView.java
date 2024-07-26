package com.frozerain.externalview;

import com.frozerain.externalview.event.registry.ModKeysEventRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = ExternalView.MODID, name = ExternalView.NAME, version = ExternalView.VERSION)
public class ExternalView {
    public static final String MODID = "externalview";
    public static final String NAME = "External View Mod";
    public static final String VERSION = "2.1";


    public static File config;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Hello from " + NAME + "-" + VERSION + "!");
        ModKeysEventRegistry.preInitialize(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Config File is", ExternalView.config);
    }

}
