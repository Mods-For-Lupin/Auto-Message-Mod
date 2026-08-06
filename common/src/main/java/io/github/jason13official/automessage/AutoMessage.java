package io.github.jason13official.automessage;

import io.github.jason13official.automessage.impl.common.message.MessageServiceUtil;
import io.github.jason13official.automessage.platform.Services;
import io.github.jason13official.monolib.MonoLib;
import io.github.jason13official.monolib.impl.common.sailing.Sailing;
import java.io.File;
import net.minecraft.resources.Identifier;

public class AutoMessage {

  public static void init() {

    Sailing.register(Constants.MOD_ID, MonoLib.createFilename(Constants.MOD_ID, "26.1.2", "1.0.0"));

    String dataPath = Services.PLATFORM.getGameDirectory() + File.separator + "automessage_data";
    File dataDirectory = new File(dataPath);
    if (!dataDirectory.isDirectory()) dataDirectory.mkdirs();
    File checkFile = new File(dataPath + File.separator + "checkfile.txt");

    if (!checkFile.exists()) {
      String configPath = Services.PLATFORM.getGameDirectory() + File.separator + "config";
      File configDirectory = new File(configPath);
      if (!configDirectory.isDirectory()) configDirectory.mkdirs();

      File readmeFile = new File(configPath + File.separator + Constants.MOD_ID + "_README.txt");
      MessageServiceUtil.copyResourceToFile("/assets/automessage/automessage_README.txt", readmeFile);
      MessageServiceUtil.copyResourceToFile("/assets/automessage/checkfile.txt", checkFile);
    }
  }

  public static Identifier identifier(final String path) {
    return Identifier.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}