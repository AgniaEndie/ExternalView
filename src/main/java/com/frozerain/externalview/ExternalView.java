package com.frozerain.externalview;

import com.frozerain.externalview.event.registry.ModKeysEventRegistry;
import com.frozerain.externalview.networking.ExternalViewNetworkWrapper;
import com.frozerain.externalview.networking.messages.AttributePacket;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ExternalView.MODID, name = ExternalView.NAME, version = ExternalView.VERSION)
public class ExternalView {
    public static final String MODID = "externalview";
    public static final String NAME = "External View Mod";
    public static final String VERSION = "2.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if(FMLCommonHandler.instance().getSide() == Side.CLIENT){
            ModKeysEventRegistry.preInitialize(event);
        }
        ExternalViewNetworkWrapper.INSTANCE.registerMessage(AttributePacket.AttributePacketHandler.class,AttributePacket.class,0,Side.SERVER);
    }

}
