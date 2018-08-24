package nycuro;

import nycuro.tasks.MessagesTask;
import nycuro.utils.Settings;

import org.itxtech.nemisys.plugin.PluginBase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * author: NycuRO
 * SimpleMessages-Nemisys Project
 * API 1.0.0
 */
public class SimpleMessagesMain extends PluginBase {

    @Override
    public void onLoad() {
        registerAPI();
    }

    @Override
    public void onEnable() {
        createConfig();
        registerTasks();
    }

    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelAllTasks();
    }

    private void registerAPI() {
        SimpleMessagesAPI.mainAPI = this;
        SimpleMessagesAPI.settingsAPI = new Settings();
    }

    private void registerTasks() {
        // synapse have 100 tps, not 20 like nukkit
        this.getServer().getScheduler().scheduleRepeatingTask(new MessagesTask(),
                SimpleMessagesAPI.getSettingsAPI().mechanic.getPeriod() * 100, SimpleMessagesAPI.getSettingsAPI().mechanic.isAsync());
    }

    private void createConfig() {
        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));
        SimpleMessagesAPI.getSettingsAPI().init();
    }

    public String time() {
        String timeString = String.valueOf(SimpleMessagesAPI.getSettingsAPI().mechanic.getCountry());
        TimeZone timeZone = TimeZone.getTimeZone(timeString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return String.valueOf(hour + ":" + minute + ":" + second);
    }
}
