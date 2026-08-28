package com.sledz.sledzinstruments.client.gui.instrument.panflute;

import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.client.gui.instrument.banjo.BanjoScreen;
import com.sledz.sledzinstruments.client.gui.instrument.viola.ViolaScreen;
import com.sledz.sledzinstruments.sound.ModSounds;
import com.cstav.genshinstrument.client.gui.screen.instrument.partial.InstrumentThemeLoader;
import com.cstav.genshinstrument.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import com.cstav.genshinstrument.sound.NoteSound;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PanfluteScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(SIMain.MODID, "panflute");

    @Override
    public NoteSound[] getInitSounds() {
        return ModSounds.PANFLUTE;
    }

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
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
