package com.frozerain.externalview.event.server;

import com.frozerain.externalview.ExternalView;
import com.frozerain.externalview.config.Configs;
import com.frozerain.externalview.key.ModKeys;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = ExternalView.MODID)

public class ServerEventHandler {
    private static boolean flag = false;
    private static final Logger logger = LogManager.getLogger(ExternalView.MODID);


    @SubscribeEvent
    public static void playerEventHandler(TickEvent.PlayerTickEvent event) {
        if (ModKeys.TURN_LONG_HAND.isPressed()) {
            if (flag) {
                logger.info("TRUE");
                event.player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).setBaseValue(Configs.reach);
                flag = false;
            } else {
                logger.info("FALSE");
                event.player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).setBaseValue(5.0f);
                flag = true;
            }
        }
    }
}
