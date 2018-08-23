package nycuro;

import javafx.scene.input.DataFormat;
import nycuro.tasks.MessagesTask;
import nycuro.utils.Settings;

import org.itxtech.nemisys.math.NemisysMath;
import org.itxtech.nemisys.plugin.PluginBase;
import org.itxtech.nemisys.utils.Config;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * author: NycuRO
 * SimpleMessages-Nemisys Project
 * API 1.0.0
 */
public class SimpleMessagesMain extends PluginBase {

    public Config settings;

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
        Object periodValue = Settings.mechanic.toArray()[0];
        String periodString = String.valueOf(periodValue);
        Integer period = Integer.valueOf(periodString);
        Object asyncValue = Settings.mechanic.toArray()[1];
        String asyncString = String.valueOf(asyncValue);
        Boolean async = Boolean.valueOf(asyncString);
        // synapse have 100 tps, not 20 like nukkit
        this.getServer().getScheduler().scheduleRepeatingTask(new MessagesTask(), period * 100, async);
    }

    private void createConfig() {
        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));
        Config settings = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML);
        this.settings = settings;
        settings.save();
        Settings.init(settings);
    }

    public static String time() {
        Object timeValue = Settings.mechanic.toArray()[2];
        String timeString = String.valueOf(timeValue);
        TimeZone timeZone = TimeZone.getTimeZone(timeString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return String.valueOf(hour + ":" + minute + ":" + second);
    }
}
