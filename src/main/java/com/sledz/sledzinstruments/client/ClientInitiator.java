package com.sledz.sledzinstruments.client;

import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.client.gui.instrument.accordeon.AccordeonScreen;
import com.sledz.sledzinstruments.client.gui.instrument.banjo.BanjoScreen;
import com.sledz.sledzinstruments.client.gui.instrument.cello.CelloScreen;
import com.sledz.sledzinstruments.client.gui.instrument.flute.FluteScreen;
import com.sledz.sledzinstruments.client.gui.instrument.harmonica.HarmonicaScreen;
import com.sledz.sledzinstruments.client.gui.instrument.panflute.PanfluteScreen;
import com.sledz.sledzinstruments.client.gui.instrument.viola.ViolaScreen;
import com.cstav.genshinstrument.client.gui.screen.instrument.InstrumentScreenRegistry;
import com.cstav.genshinstrument.client.gui.screen.instrument.partial.InstrumentScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;
import java.util.function.Supplier;

import static java.util.Map.entry;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD, modid = SIMain.MODID)
public class ClientInitiator {

    private static final Map<ResourceLocation, Supplier<? extends InstrumentScreen>> INSTRUMENTS = Map.ofEntries(

            entry(HarmonicaScreen.INSTRUMENT_ID, HarmonicaScreen::new),
            entry(BanjoScreen.INSTRUMENT_ID, BanjoScreen::new),
            entry(PanfluteScreen.INSTRUMENT_ID, PanfluteScreen::new),
            entry(FluteScreen.INSTRUMENT_ID, FluteScreen::new),
            entry(AccordeonScreen.INSTRUMENT_ID, AccordeonScreen::new),
            entry(ViolaScreen.INSTRUMENT_ID, ViolaScreen::new),
            entry(CelloScreen.INSTRUMENT_ID, CelloScreen::new)
    );

    @SubscribeEvent
    public static void setupClient(final FMLClientSetupEvent event) {
        InstrumentScreenRegistry.register(INSTRUMENTS);
    }

}
