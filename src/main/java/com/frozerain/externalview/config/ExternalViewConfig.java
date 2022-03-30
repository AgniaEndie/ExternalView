package com.frozerain.externalview.config;

import com.frozerain.externalview.ExternalView;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;


public class ExternalViewConfig {
    public static Configuration config;

    public static float cameraspeed;

    public static void init(File file) {
        config = new Configuration(file);
        String category;
        category = "Camera Speed";
        config.addCustomCategoryComment(category, "Set your camera speed");
        cameraspeed = config.getFloat("Camera", category, 0.5f, 0.1f, 10, "Camera Speed");
        if(cameraspeed == 0.0f){
            cameraspeed = 0.5f;
        }
        config.save();

    }



    public static void registerConfig(FMLPreInitializationEvent event)
    {
        ExternalView.config = new File(event.getModConfigurationDirectory() + "/" + ExternalView.MODID);
        ExternalView.config.mkdirs();
        init(new File(ExternalView.config.getPath(), ExternalView.MODID + ".cfg"));
    }
}
