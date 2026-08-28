package com.sledz.sledzinstruments.client.gui.instrument.accordeon;

import com.cstav.genshinstrument.client.gui.screen.instrument.partial.InstrumentThemeLoader;
import com.cstav.genshinstrument.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import com.cstav.genshinstrument.sound.NoteSound;
import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.client.gui.instrument.viola.ViolaScreen;
import com.sledz.sledzinstruments.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;

public class AccordeonScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(SIMain.MODID, "accordeon");

    @Override
    public NoteSound[] getInitSounds() {
        return ModSounds.ACCORDEON;
    }

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }

    @Override
    public boolean isGenshinInstrument() {
        return false;
    }

    public static final InstrumentThemeLoader THEME_LOADER = InstrumentThemeLoader.fromOther(
            ViolaScreen.THEME_LOADER,
            INSTRUMENT_ID
    );

    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }
}
