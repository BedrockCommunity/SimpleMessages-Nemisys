package nycuro;

import nycuro.utils.Settings;

/**
 * author: NycuRO
 * SimpleMessages-Nemisys Project
 * API 1.0.0
 */
public class SimpleMessagesAPI {

    public static SimpleMessagesMain mainAPI;

    public static Settings settingsAPI;

    public static SimpleMessagesMain getMainAPI() {
        return mainAPI;
    }

    public static Settings getSettingsAPI() { return settingsAPI; }
}
