package io.github.jason13official.automessage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

public class AutoMessageFabric implements ModInitializer {

  @Override
  public void onInitialize() {

    AutoMessage.init();

    ServerLifecycleEvents.SERVER_STARTING.register(AutoMessageServerFabric::new);

    ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
      if (!(entity instanceof ServerPlayer player) || serverLevel == null) return;

      AutoMessageServer.onFirstJoinLevel(player, serverLevel);
      AutoMessageServer.onJoinLevel(player, serverLevel);
    });

    ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(AutoMessage.identifier(Constants.MOD_ID), new ResourceReloadListener());
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
