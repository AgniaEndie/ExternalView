package com.frozerain.externalview.config;

import com.frozerain.externalview.ExternalView;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ExternalView.MODID)
@Mod.EventBusSubscriber(modid = ExternalView.MODID)
public class Configs {

    @Config.LangKey(ExternalView.MODID + ".cfg.camspeed")
    @Config.Comment("    Camera Speed, from 0.01 to 10, default = 0.5")
    @Config.RequiresMcRestart
    public static float cameraspeed =  0.5f;

    @Config.LangKey(ExternalView.MODID + ".cfg.jenya")
    @Config.Comment("View Distance, from 1 to 128, default = 56")
    @Config.RequiresMcRestart
    public static float viewdistance = 56f;





    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equals(ExternalView.MODID)){
            ConfigManager.sync(ExternalView.MODID,Config.Type.INSTANCE);
            //FMLCommonHandler.instance().bus().register(new );
        }
    }
}
/*
@Config(modid= ExternalView.MODID)
@Mod.EventBusSubscriber(modid =  ExternalView.MODID)
public class Configs
{
    @Config.LangKey(ExternalView.MODID + ".cfg.sub.camera") // Локализированное имя категории (Если не будет указано, пункт будет именть название переменной)
    @Config.Comment("Here you can change camera speed") // Описание которое выводится при наведении на категорию
    public static OtherSettings OtherSettings = new OtherSettings(); // Создаём категорию

    public static class OtherSettings {
        @Config.LangKey(ExternalView.MODID + ".cfg.sub.other.cameraspeed") // Локализированное имя пункта (Если не будет указано, пункт будет именть название переменной)
        public String camera_description = "Default description";

        @Config.LangKey(ExternalView.MODID + ".cfg.sub.other.item1_description1") // Локализированное имя пункта (Если не будет указано, пункт будет именть название переменной)
        public String item1_description2 = "Secret description";
    }

    @Config.LangKey(ExternalView.MODID + ".cfg.camspeed")
    @Config.Comment("Camera Speed, from 0.1 to 10")
    @Config.RequiresWorldRestart
    public static float cameraspeed = 5;

    // Данное событие нужно для того, чтобы все значения которые были изменены в игре, перезаписывались в самом конфиг файле
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ExternalView.MODID)) {
            ConfigManager.sync(ExternalView.MODID, Config.Type.INSTANCE);
        }
    }
}*/
