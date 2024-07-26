package com.frozerain.externalview.config;

import com.frozerain.externalview.ExternalView;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ExternalView.MODID)
@Mod.EventBusSubscriber(modid = ExternalView.MODID)
public class Configs {

    @Config.LangKey(ExternalView.MODID + ".cfg.camspeed")
    @Config.Comment("    Camera Speed, from 0.01 to 10, default = 0.5")
    @Config.RequiresMcRestart
    public static float cameraSpeed =  0.5f;

    @Config.LangKey(ExternalView.MODID + ".cfg.jenya")
    @Config.Comment("View Distance, from 1 to 128, default = 56")
    @Config.RequiresMcRestart
    public static float viewDistance = 56f;

    @Config.LangKey(ExternalView.MODID + ".cfg.reach")
    @Config.Comment("Reach  Distance, from 1 to 1024, default = 40")
    public static float reach = 40.0f;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equals(ExternalView.MODID)){
            ConfigManager.sync(ExternalView.MODID,Config.Type.INSTANCE);
        }
    }
}
