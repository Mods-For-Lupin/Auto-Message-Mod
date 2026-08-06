package io.github.jason13official.automessage;

import java.util.function.Consumer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
public class AutoMessageForge {

  public static IEventBus EVENT_BUS;

  public AutoMessageForge(final FMLJavaModLoadingContext context) {

    EVENT_BUS = context.getModEventBus();

    AutoMessage.init();

    MinecraftForge.EVENT_BUS.addListener((Consumer<AddReloadListenerEvent>) event -> {
      event.addListener(new ResourceReloadListener());
    });

    if (FMLLoader.getDist() == Dist.CLIENT) {
      new AutoMessageClientForge(EVENT_BUS);
    }
  }

  @Deprecated
  @SuppressWarnings("all")
  public AutoMessageForge() {
    this(FMLJavaModLoadingContext.get());
  }

  public static class ResourceReloadListener extends SimplePreparableReloadListener<Void> {

    @Override
    public String getName() {
      return AutoMessage.identifier(Constants.MOD_ID).toString();
    }

    @Override
    protected void apply(Void unused, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
      // ModConfig.load(Services.PLATFORM.getConfigDirectory());
    }

    @Override
    protected Void prepare(ResourceManager resourceManager, ProfilerFiller profilerFiller) {
      return null;
    }
  }
}