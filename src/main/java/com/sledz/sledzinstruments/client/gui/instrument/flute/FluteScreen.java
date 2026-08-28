package com.sledz.sledzinstruments.client.gui.instrument.flute;

import com.cstav.genshinstrument.client.gui.screen.instrument.partial.InstrumentThemeLoader;
import com.cstav.genshinstrument.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import com.cstav.genshinstrument.sound.NoteSound;
import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.client.gui.instrument.banjo.BanjoScreen;
import com.sledz.sledzinstruments.client.gui.instrument.viola.ViolaScreen;
import com.sledz.sledzinstruments.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FluteScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(SIMain.MODID, "flute");

    @Override
    public NoteSound[] getInitSounds() {
        return ModSounds.FLUTE;
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