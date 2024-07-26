package com.frozerain.externalview.event.server;

import com.frozerain.externalview.ExternalView;
import com.frozerain.externalview.config.Configs;
import com.frozerain.externalview.key.ModKeys;
import com.frozerain.externalview.networking.ExternalViewNetworkWrapper;
import com.frozerain.externalview.networking.messages.AttributePacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = ExternalView.MODID)

public class ServerEventHandler {
    private static boolean flag = false;


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void playerEventHandler(TickEvent event) {
        if (ModKeys.TURN_LONG_HAND.isPressed()) {
            if (Minecraft.getMinecraft().world.isRemote) {
                if (flag) {
                    ExternalViewNetworkWrapper.INSTANCE.sendToServer(new AttributePacket((int) Configs.reach));
                    flag = false;
                } else {
                    ExternalViewNetworkWrapper.INSTANCE.sendToServer(new AttributePacket((5)));
                    flag = true;
                }
            }
        }
    }

}
