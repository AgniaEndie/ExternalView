package com.frozerain.externalview.networking;

import com.frozerain.externalview.ExternalView;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class ExternalViewNetworkWrapper {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ExternalView.MODID);


}
