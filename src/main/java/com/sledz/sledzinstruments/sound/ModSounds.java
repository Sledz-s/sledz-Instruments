package com.sledz.sledzinstruments.sound;

import com.sledz.sledzinstruments.SIMain;
import com.cstav.genshinstrument.sound.NoteSound;
import com.cstav.genshinstrument.sound.registrar.NoteSoundRegistrar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SIMain.MODID);
    public static void register(final IEventBus bus) {
        SOUNDS.register(bus);
    }

    public static final NoteSound[]

    //======================================================

        HARMONICA = nsr(loc("harmonica")).registerGrid(),
        BANJO = nsr(loc("banjo")).registerGrid(),
        PANFLUTE = nsr(loc("panflute")).registerGrid(),
        FLUTE = nsr(loc("flute")).registerGrid(),
        CELLO = nsr(loc("cello")).registerGrid(),
        VIOLA = nsr(loc("viola")).registerGrid(),
        ACCORDEON = nsr(loc("accordeon")).registerGrid()

    //======================================================
    ;

    private static ResourceLocation loc(final String id) {
        return new ResourceLocation(SIMain.MODID, id);
    }
    /**
     * Shorthand for {@code new NoteSoundRegistrar(soundRegistrar, instrumentId)}
     */
    private static NoteSoundRegistrar nsr(ResourceLocation instrumentId) {
        return new NoteSoundRegistrar(ModSounds.SOUNDS, instrumentId);
    }

}
