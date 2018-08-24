package nycuro;

import nycuro.tasks.MessagesTask;
import nycuro.utils.Settings;
import nycuro.utils.objects.Mechanic;

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
    }

    private void registerTasks() {
        Mechanic mechanic = new Mechanic();
        // synapse have 100 tps, not 20 like nukkit
        this.getServer().getScheduler().scheduleRepeatingTask(new MessagesTask(), mechanic.getPeriod() * 100, mechanic.isAsync());
    }

    private void createConfig() {
        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));
        Settings.init();
    }

    public static String time() {
        Mechanic mechanic = new Mechanic();
        String timeString = String.valueOf(mechanic.getCountry());
        TimeZone timeZone = TimeZone.getTimeZone(timeString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return String.valueOf(hour + ":" + minute + ":" + second);
    }
}
