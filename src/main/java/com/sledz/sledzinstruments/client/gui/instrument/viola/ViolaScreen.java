package com.sledz.sledzinstruments.client.gui.instrument.viola;

import com.cstav.genshinstrument.client.gui.screen.instrument.partial.InstrumentThemeLoader;
import com.cstav.genshinstrument.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import com.cstav.genshinstrument.sound.NoteSound;
import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;

public class ViolaScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(SIMain.MODID, "viola");

    @Override
    public NoteSound[] getInitSounds() {
        return ModSounds.VIOLA;
    }

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }

    @Override
    public boolean isGenshinInstrument() {
        return false;
    }


    public static final InstrumentThemeLoader THEME_LOADER = new InstrumentThemeLoader(INSTRUMENT_ID);

    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }

}
