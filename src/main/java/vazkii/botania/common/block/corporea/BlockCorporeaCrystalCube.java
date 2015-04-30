/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Apr 30, 2015, 3:56:19 PM (GMT)]
 */
package vazkii.botania.common.block.corporea;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import vazkii.botania.client.lib.LibRenderIDs;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.block.tile.corporea.TileCorporeaBase;
import vazkii.botania.common.block.tile.corporea.TileCorporeaCrystalCube;
import vazkii.botania.common.lib.LibBlockNames;

public class BlockCorporeaCrystalCube extends BlockCorporeaBase {

	public BlockCorporeaCrystalCube() {
		super(Material.iron, LibBlockNames.CORPOREA_CRYSTAL_CUBE);
		setHardness(5.5F);
		setStepSound(soundTypeMetal);	
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote) {
			TileCorporeaCrystalCube cube = (TileCorporeaCrystalCube) world.getTileEntity(x, y, z);
			cube.doRequest(player.isSneaking());
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int s, float xs, float ys, float zs) {
		ItemStack stack = player.getCurrentEquippedItem();
		if(stack != null) {
			TileCorporeaCrystalCube cube = (TileCorporeaCrystalCube) world.getTileEntity(x, y, z);
			cube.setRequestTarget(stack);
			return true;
		}
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return LibRenderIDs.idCorporeaCrystalCybe;
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		// NO-OP
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return ModBlocks.storage.getIcon(0, 2);
	}
	
	@Override
	public TileCorporeaBase createNewTileEntity(World world, int meta) {
		return new TileCorporeaCrystalCube();
	}

}
