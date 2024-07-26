package com.frozerain.externalview.event.client;

import com.frozerain.externalview.ExternalView;
import com.frozerain.externalview.config.Configs;
import com.frozerain.externalview.key.ModKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ExternalView.MODID, value = Side.CLIENT)
public class ClientEventHandler {
    private static float additionThirdPersonCameraDistance = 0.0F;
    public static float a = Configs.cameraSpeed;
    public static float b = Configs.viewDistance;

    @SubscribeEvent
    public static void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;
        GameSettings gameSettings = mc.gameSettings;

        if (player != null && gameSettings.thirdPersonView == 1) {

            if (ModKeys.ZOOM_OUT.isKeyDown()) {
                additionThirdPersonCameraDistance += a;
                if (additionThirdPersonCameraDistance > b) {
                    additionThirdPersonCameraDistance = b;
                }
            }

            if (ModKeys.ZOOM_IN.isKeyDown()) {
                additionThirdPersonCameraDistance -= a;
                if (additionThirdPersonCameraDistance < 0) {
                    additionThirdPersonCameraDistance = 0.0F;
                }
            }

            GlStateManager.translate(0.0F, 0.0F, -additionThirdPersonCameraDistance);
        }else if(player != null && gameSettings.thirdPersonView == 2){
            if (ModKeys.ZOOM_OUT.isKeyDown()) {
                additionThirdPersonCameraDistance += a;
                if (additionThirdPersonCameraDistance > b) {
                    additionThirdPersonCameraDistance = b;
                }
            }

            if (ModKeys.ZOOM_IN.isKeyDown()) {
                additionThirdPersonCameraDistance -= a;
                if (additionThirdPersonCameraDistance < 0) {
                    additionThirdPersonCameraDistance = 0.0F;
                }
            }

            GlStateManager.translate(0.0F, 0.0F, +additionThirdPersonCameraDistance);
        }

        else
            additionThirdPersonCameraDistance = 0.0F;
    }


}
