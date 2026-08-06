package io.github.jason13official.automessage;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

public class AutoMessageClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    AutoMessageClient.init(Minecraft.getInstance());
  }
}
