package io.github.jason13official.automessage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class AutoMessageFabric implements ModInitializer {

  @Override
  public void onInitialize() {

    AutoMessage.init();

    ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new ResourceReloadListener());
  }

  public static class ResourceReloadListener implements SimpleSynchronousResourceReloadListener {

    @Override
    public ResourceLocation getFabricId() {
      return AutoMessage.identifier(Constants.MOD_ID);
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
      // ModConfig.load(Services.PLATFORM.getConfigDirectory());
    }
  }
}
