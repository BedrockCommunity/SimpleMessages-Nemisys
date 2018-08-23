package nycuro.utils;

import org.itxtech.nemisys.utils.Config;

import java.util.List;

/**
 * author: NycuRO
 * SimpleMessages-Nemisys Project
 * API 1.0.0
 */
public class Settings {

    public static List<String> messages;

    public static List<String> mechanic;

    public static void init(Config config) {
        Config cfg = config;
        messages = cfg.getSection("messages").getStringList("broadcast");
        mechanic = cfg.getSection("mechanic").getStringList("values");
    }
}
