/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Aug 28, 2015, 5:16:17 PM (GMT)]
 */
package vazkii.botania.client.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;

public class ModelBellows extends Model {

	final RendererModel top;
	final RendererModel base;
	final RendererModel pipe;
	final RendererModel funnel;

	public ModelBellows() {
		textureWidth = 64;
		textureHeight = 32;
		
		top = new RendererModel(this, 0, 0);
        top.setRotationPoint(0.0F, 16.0F, 0.0F);
        top.addBox(-4.0F, -2.0F, -4.0F, 8, 1, 8, 0.0F);
        base = new RendererModel(this, 0, 9);
        base.setRotationPoint(0.0F, 16.0F, 0.0F);
        base.addBox(-5.0F, 6.0F, -5.0F, 10, 2, 10, 0.0F);
        pipe = new RendererModel(this, 0, 21);
        pipe.setRotationPoint(0.0F, 16.0F, 0.0F);
        pipe.addBox(-1.0F, 6.0F, -8.0F, 2, 2, 3, 0.0F);
		
        funnel = new RendererModel(this, 40, 0);
        funnel.setRotationPoint(0.0F, 0.0F, 0.0F);
        funnel.addBox(0.0F, 0.0F, 0.0F, 6, 7, 6, 0.0F);
	}

	public void render(float fract) {
		float f5 = 1F / 16F;
		base.render(f5);
		pipe.render(f5);

		//float fract = Math.max(0.1F, (float) (Math.sin(((double) ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks) * 0.2) + 1F) * 0.5F);
		float mov = (1F - fract) * 0.5F;

		GlStateManager.translatef(0F, mov, 0F);
		top.render(f5);
		GlStateManager.translatef(0F, -mov, 0F);

		GlStateManager.rotatef(180F, 1F, 0F, 0F);
		GlStateManager.translatef(-0.19F, -1.375F, -0.19F);
		GlStateManager.scalef(1F, fract, 1F);
		funnel.render(f5);
		GlStateManager.scalef(1F, 1F / fract, 1F);
	}


}
