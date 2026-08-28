package com.sledz.sledzinstruments.item;

import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.item.partial.instrument.CreditableInstrumentItem;
import com.sledz.sledzinstruments.item.partial.instrument.CreditableWindInstrumentItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

import static com.cstav.genshinstrument.networking.packet.instrument.util.InstrumentPacketUtil.sendOpenPacket;

@EventBusSubscriber(modid = SIMain.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SIMain.MODID);
    public static void register(final IEventBus bus) {
        ITEMS.register(bus);
    }

    private static final LinkedHashMap<ResourceKey<CreativeModeTab>, ArrayList<RegistryObject<Item>>> CREATIVE_TABS_MAP = new LinkedHashMap<>();
    private static ArrayList<RegistryObject<Item>> getCreativeItems(final ResourceKey<CreativeModeTab> tabKey) {
        if (!CREATIVE_TABS_MAP.containsKey(tabKey))
            CREATIVE_TABS_MAP.put(tabKey, new ArrayList<>());
        return CREATIVE_TABS_MAP.get(tabKey);
    }

    @SuppressWarnings("unchecked")
    private static final ResourceKey<CreativeModeTab>[] DEFAULT_INSTRUMENTS_TABS = new ResourceKey[] {
            SIModCreativeModeTabs.SLEDZ_INSTRUMENTS_TAB.getKey(), CreativeModeTabs.TOOLS_AND_UTILITIES
    };
    @SuppressWarnings("unchecked")
    private static final ResourceKey<CreativeModeTab>[] DEFAULT_INSTRUMENT_BLOCK_TABS = new ResourceKey[] {
            SIModCreativeModeTabs.SLEDZ_INSTRUMENTS_TAB.getKey(), CreativeModeTabs.TOOLS_AND_UTILITIES, CreativeModeTabs.FUNCTIONAL_BLOCKS
    };

    public static final RegistryObject<Item>
    //================================================================================================
    // Instruments

    HARMONICA = register("harmonica", () -> new CreditableWindInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("harmonica")
            ),
            "Korg AG-10"
    )),

    BANJO = register("banjo", () -> new CreditableInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("banjo")
            ),
            "Wii music"
    )),

    PANFLUTE = register("panflute", () -> new CreditableWindInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("panflute")
            ),
            "Korg AG-10"
    )),

    CELLO = register("cello", () -> new CreditableInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("cello")
            ),
            "Sine Instruments"
    )),

    ACCORDEON = register("accordeon", () -> new CreditableInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("accordeon")
            ),
            "Musescore 4"
    )),

    VIOLA = register("viola", () -> new CreditableInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("viola")
            ),
            "Musescore 4"
    )),

    FLUTE = register("flute", () -> new CreditableWindInstrumentItem(
            (player) -> sendOpenPacket(
                    player, loc("flute")
            ),
            "Sine Instruments"
    ))
            ;

    private static ResourceLocation loc(final String path) {
        return new ResourceLocation(SIMain.MODID, path);
    }

    @SafeVarargs
    private static RegistryObject<Item> registerBlockItem(RegistryObject<Block> block, ResourceKey<CreativeModeTab>... tabs) {
        return register(
                block.getId().getPath(),
                () -> new BlockItem(block.get(), new Properties()),
                tabs
        );
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> supplier, ResourceKey<CreativeModeTab>[] tabs,
                                                 RegistryObject<Item> appearsBefore) {
        final RegistryObject<Item> item = ITEMS.register(name, supplier);

        for (final ResourceKey<CreativeModeTab> tabKey : tabs) {
            final ArrayList<RegistryObject<Item>> items = getCreativeItems(tabKey);
            if (items.contains(appearsBefore)) {
                items.add(items.indexOf(appearsBefore), item);
            } else {
                items.add(item);
            }
        }

        return item;
    }
    @SafeVarargs
    private static RegistryObject<Item> register(String name, Supplier<Item> supplier, ResourceKey<CreativeModeTab>... tabs) {
        final RegistryObject<Item> item = ITEMS.register(name, supplier);

        for (final ResourceKey<CreativeModeTab> tabKey: tabs) {
            getCreativeItems(tabKey).add(item);
        }

        return item;
    }
    private static RegistryObject<Item> register(String name, Supplier<Item> supplier) {
        return register(name, supplier, DEFAULT_INSTRUMENTS_TABS);
    }

    @SubscribeEvent
    public static void addCreative(final BuildCreativeModeTabContentsEvent event) {
        CREATIVE_TABS_MAP.keySet().forEach((tabKey) -> {
            if (!event.getTabKey().equals(tabKey))
                return;

            event.acceptAll(
                    getCreativeItems(tabKey).stream()
                            .map((item) -> new ItemStack(item.get()))
                            .toList()
            );
        });
    }
}