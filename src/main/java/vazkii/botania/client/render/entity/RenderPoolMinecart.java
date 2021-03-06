/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Mar 17, 2015, 11:17:48 PM (GMT)]
 */
package vazkii.botania.client.render.entity;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import vazkii.botania.client.core.handler.ClientTickHandler;
import vazkii.botania.client.render.tile.RenderTilePool;
import vazkii.botania.common.block.mana.BlockPool;
import vazkii.botania.common.block.tile.mana.TilePool;
import vazkii.botania.common.entity.EntityPoolMinecart;

import javax.annotation.Nonnull;

public class RenderPoolMinecart extends MinecartRenderer<EntityPoolMinecart> {

	public RenderPoolMinecart(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected void renderCartContents(EntityPoolMinecart poolCart, float partialTicks, @Nonnull BlockState state) {
		super.renderCartContents(poolCart, partialTicks, state);
		RenderTilePool.cartMana = poolCart.getMana();
		TileEntityRendererDispatcher.instance.getRenderer(TilePool.class).render(null, poolCart.posX, poolCart.posY, poolCart.posZ, ClientTickHandler.partialTicks, -1);
	}


}
