package com.frozerain.externalview.networking.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributePacket implements IMessage {

    private int value;

    public AttributePacket() {}

    public AttributePacket(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        value = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(value);
    }

    // FML DOCS
    public static class AttributePacketHandler implements IMessageHandler<AttributePacket, IMessage> {

        Logger logger = LoggerFactory.getLogger(AttributePacket.class);
        @Override
        public IMessage onMessage(AttributePacket packet, MessageContext ctx) {
            EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
            float value = (float) packet.value;
            logger.error("handled - " + value + " from " + serverPlayer.getName());
            serverPlayer.getServerWorld().addScheduledTask(() -> serverPlayer.getEntityAttribute(EntityPlayerMP.REACH_DISTANCE).setBaseValue(value));
            return null;
        }
    }
}
