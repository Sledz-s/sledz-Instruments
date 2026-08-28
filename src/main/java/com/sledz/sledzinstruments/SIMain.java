package com.sledz.sledzinstruments;


import com.sledz.sledzinstruments.gamerule.ModGameRules;
import com.sledz.sledzinstruments.item.ModItems;
import com.sledz.sledzinstruments.item.SIModCreativeModeTabs;
import com.sledz.sledzinstruments.item.crafting.ModRecipeSerializers;
import com.sledz.sledzinstruments.sound.ModSounds;
import com.sledz.sledzinstruments.util.CommonUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(SIMain.MODID)
public class SIMain
{
    public static final String MODID = "sledzinstruments";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static CompoundTag modTag(final ItemStack item) {
        return item.getOrCreateTagElement(MODID);
    }
    public static CompoundTag modTag(final BlockEntity be) {
        return CommonUtil.getOrCreateElementTag(be.getPersistentData(), MODID);
    }

    public SIMain()
    {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModSounds.register(bus);

        ModGameRules.load();

        SIModCreativeModeTabs.register(bus);

        ModItems.register(bus);
        ModRecipeSerializers.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}