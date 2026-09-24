package com.example

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.*
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import org.slf4j.LoggerFactory

object AtheniaSHasowzyMod : ModInitializer {

    const val MOD_ID = "atheniashasowzymod"
    private val LOGGER = LoggerFactory.getLogger(MOD_ID)

    // --------------------------------------------------
    // BLOKLAR
    // --------------------------------------------------

    val HASOWZY_ORE = registerBlock(
        "hasowzy_ore",
        Block(
            BlockBehaviour.Properties.of()
                .setId(blockKey("hasowzy_ore"))
                .strength(3.0f, 3.0f)
                .requiresCorrectToolForDrops()
        )
    )

    val GUBE_ORE = registerBlock(
        "gube_ore",
        Block(
            BlockBehaviour.Properties.of()
                .setId(blockKey("gube_ore"))
                .strength(3.0f, 3.0f)
                .requiresCorrectToolForDrops()
        )
    )

    val HASOWZY_BLOCK = registerBlock(
        "hasowzy_block",
        Block(
            BlockBehaviour.Properties.of()
                .setId(blockKey("hasowzy_block"))
                .strength(5.0f, 6.0f)
                .requiresCorrectToolForDrops()
        )
    )

    val GUBE_BLOCK = registerBlock(
        "gube_block",
        Block(
            BlockBehaviour.Properties.of()
                .setId(blockKey("gube_block"))
                .strength(5.0f, 6.0f)
                .requiresCorrectToolForDrops()
        )
    )

    // --------------------------------------------------
    // NORMAL ITEMLAR
    // --------------------------------------------------

    val GUBE = registerItem(
        "gube",
        Item(Item.Properties().setId(itemKey("gube")))
    )

    val HASOWZY_INGOT = registerItem(
        "hasowzy_ingot",
        Item(Item.Properties().setId(itemKey("hasowzy_ingot")))
    )

    // --------------------------------------------------
    // HASOWZY ALETLERİ & ZIRHLARI
    // --------------------------------------------------

    val HASOWZY_SWORD = registerItem(
        "hasowzy_sword",
        Item(Item.Properties().setId(itemKey("hasowzy_sword")))
    )

    val HASOWZY_PICKAXE = registerItem(
        "hasowzy_pickaxe",
        Item(Item.Properties().setId(itemKey("hasowzy_pickaxe")))
    )

    val HASOWZY_AXE = registerItem(
        "hasowzy_axe",
        Item(Item.Properties().setId(itemKey("hasowzy_axe")))
    )

    val HASOWZY_SHOVEL = registerItem(
        "hasowzy_shovel",
        Item(Item.Properties().setId(itemKey("hasowzy_shovel")))
    )

    val HASOWZY_HOE = registerItem(
        "hasowzy_hoe",
        Item(Item.Properties().setId(itemKey("hasowzy_hoe")))
    )

    val HASOWZY_HELMET = registerItem(
        "hasowzy_helmet",
        Item(Item.Properties().setId(itemKey("hasowzy_helmet")))
    )

    val HASOWZY_CHESTPLATE = registerItem(
        "hasowzy_chestplate",
        Item(Item.Properties().setId(itemKey("hasowzy_chestplate")))
    )

    val HASOWZY_LEGGINGS = registerItem(
        "hasowzy_leggings",
        Item(Item.Properties().setId(itemKey("hasowzy_leggings")))
    )

    val HASOWZY_BOOTS = registerItem(
        "hasowzy_boots",
        Item(Item.Properties().setId(itemKey("hasowzy_boots")))
    )

    // --------------------------------------------------
    // GUBE ALETLERİ & ZIRHLARI
    // --------------------------------------------------

    val GUBE_SWORD = registerItem(
        "gube_sword",
        Item(Item.Properties().setId(itemKey("gube_sword")))
    )

    val GUBE_PICKAXE = registerItem(
        "gube_pickaxe",
        Item(Item.Properties().setId(itemKey("gube_pickaxe")))
    )

    val GUBE_AXE = registerItem(
        "gube_axe",
        Item(Item.Properties().setId(itemKey("gube_axe")))
    )

    val GUBE_SHOVEL = registerItem(
        "gube_shovel",
        Item(Item.Properties().setId(itemKey("gube_shovel")))
    )

    val GUBE_HOE = registerItem(
        "gube_hoe",
        Item(Item.Properties().setId(itemKey("gube_hoe")))
    )

    val GUBE_HELMET = registerItem(
        "gube_helmet",
        Item(Item.Properties().setId(itemKey("gube_helmet")))
    )

    val GUBE_CHESTPLATE = registerItem(
        "gube_chestplate",
        Item(Item.Properties().setId(itemKey("gube_chestplate")))
    )

    val GUBE_LEGGINGS = registerItem(
        "gube_leggings",
        Item(Item.Properties().setId(itemKey("gube_leggings")))
    )

    val GUBE_BOOTS = registerItem(
        "gube_boots",
        Item(Item.Properties().setId(itemKey("gube_boots")))
    )

    // --------------------------------------------------
    // REGISTER METODLARI
    // --------------------------------------------------

    private fun registerBlock(name: String, block: Block): Block {
        Registry.register(BuiltInRegistries.BLOCK, id(name), block)
        registerItem(
            name,
            BlockItem(
                block,
                Item.Properties().setId(itemKey(name)).useBlockDescriptionPrefix()
            )
        )
        return block
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(BuiltInRegistries.ITEM, id(name), item)
    }

    // --------------------------------------------------
    // MOD BAŞLANGICI
    // --------------------------------------------------

    override fun onInitialize() {
        LOGGER.info("Athenia's Hasowzy Mod yükleniyor!")

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register { output ->
            output.accept(HASOWZY_ORE)
            output.accept(GUBE_ORE)
        }

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register { output ->
            output.accept(HASOWZY_BLOCK)
            output.accept(GUBE_BLOCK)
        }

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register { output ->
            output.accept(GUBE)
            output.accept(HASOWZY_INGOT)
        }

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register { output ->
            output.accept(HASOWZY_SWORD)
            output.accept(HASOWZY_AXE)
            output.accept(HASOWZY_HELMET)
            output.accept(HASOWZY_CHESTPLATE)
            output.accept(HASOWZY_LEGGINGS)
            output.accept(HASOWZY_BOOTS)

            output.accept(GUBE_SWORD)
            output.accept(GUBE_AXE)
            output.accept(GUBE_HELMET)
            output.accept(GUBE_CHESTPLATE)
            output.accept(GUBE_LEGGINGS)
            output.accept(GUBE_BOOTS)
        }

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register { output ->
            output.accept(HASOWZY_PICKAXE)
            output.accept(HASOWZY_SHOVEL)
            output.accept(HASOWZY_HOE)

            output.accept(GUBE_PICKAXE)
            output.accept(GUBE_AXE)
            output.accept(GUBE_SHOVEL)
            output.accept(GUBE_HOE)
        }
    }

    // --------------------------------------------------
    // YARDIMCI METODLAR
    // --------------------------------------------------

    fun id(path: String): Identifier {
        return Identifier.fromNamespaceAndPath(MOD_ID, path)
    }

    private fun itemKey(path: String): ResourceKey<Item> {
        return ResourceKey.create(Registries.ITEM, id(path))
    }

    private fun blockKey(path: String): ResourceKey<Block> {
        return ResourceKey.create(Registries.BLOCK, id(path))
    }
}