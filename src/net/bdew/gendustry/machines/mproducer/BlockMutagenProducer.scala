/*
 * Copyright (c) bdew, 2013 - 2014
 * https://github.com/bdew/gendustry
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.gendustry.machines.mproducer

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.bdew.gendustry.Gendustry
import net.bdew.gendustry.gui.BlockGuiWrenchable
import net.bdew.lib.block.HasTE
import net.bdew.lib.covers.BlockCoverable
import net.bdew.lib.tile.inventory.BreakableInventoryBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon

object BlockMutagenProducer extends Block(Material.rock) with HasTE[TileMutagenProducer] with BlockCoverable[TileMutagenProducer] with BreakableInventoryBlock with BlockGuiWrenchable {
  private var icons: Array[IIcon] = null
  val TEClass = classOf[TileMutagenProducer]
  lazy val guiId = MachineMutagenProducer.guiId

  setBlockName(Gendustry.modId + ".mutagen.producer")
  setHardness(5)

  override def getIcon(side: Int, meta: Int): IIcon = {
    side match {
      case 0 =>
        return icons(0)
      case 1 =>
        return icons(1)
      case _ =>
        return icons(2)
    }
  }

  @SideOnly(Side.CLIENT)
  override def registerBlockIcons(reg: IIconRegister) {
    icons = new Array(3)
    icons(0) = reg.registerIcon(Gendustry.modId + ":mutagenproducer/bottom")
    icons(1) = reg.registerIcon(Gendustry.modId + ":mutagenproducer/top")
    icons(2) = reg.registerIcon(Gendustry.modId + ":mutagenproducer/side")
  }
}