package io.github.jason13official.automessage;

import net.fabricmc.api.ClientModInitializer;

public class AutoMessageClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    AutoMessageClient.init();
  }
}
