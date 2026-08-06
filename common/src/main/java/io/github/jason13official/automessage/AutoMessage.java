package io.github.jason13official.automessage;

import net.minecraft.resources.ResourceLocation;


public class AutoMessage {

  public static void init() {
  }

  public static ResourceLocation identifier(final String path) {
    return new ResourceLocation(Constants.MOD_ID, path);
  }
}