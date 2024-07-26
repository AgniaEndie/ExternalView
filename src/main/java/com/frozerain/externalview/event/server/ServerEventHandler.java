package com.frozerain.externalview.event.server;

import com.frozerain.externalview.ExternalView;
import com.frozerain.externalview.config.Configs;
import com.frozerain.externalview.key.ModKeys;
import com.frozerain.externalview.networking.ExternalViewNetworkWrapper;
import com.frozerain.externalview.networking.messages.AttributePacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = ExternalView.MODID)

public class ServerEventHandler {
    private static boolean flag = false;
    private static final Logger logger = LogManager.getLogger(ExternalView.MODID);

    @SubscribeEvent
    public static void playerEnter(PlayerEvent.PlayerLoggedInEvent playerEvent) {
        try {
            logger.error("gmm");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void playerEventHandler(TickEvent event) {
        if (ModKeys.TURN_LONG_HAND.isPressed()) {
            if(Minecraft.getMinecraft().world.isRemote){
                if (flag) {
                    ExternalViewNetworkWrapper.INSTANCE.sendToServer(new AttributePacket((int) Configs.reach));
                    logger.info("SENDED");
                    flag = false;
                } else {
                    ExternalViewNetworkWrapper.INSTANCE.sendToServer(new AttributePacket((5)));
                    logger.info("SENDED-se");
                    flag = true;
                }
            }

        }

    }

    @SubscribeEvent
    @SideOnly(Side.SERVER)
    public static void playerServerEventHandler(TickEvent.PlayerTickEvent event) {

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void handleRemotePacket(FMLNetworkEvent.ClientCustomPacketEvent rPacket) {
        logger.error("HANDLE RESPONSE");
    }

}
