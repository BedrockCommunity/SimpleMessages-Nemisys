package nycuro;

import nycuro.tasks.MessagesTask;
import nycuro.utils.Settings;

import org.itxtech.nemisys.plugin.PluginBase;
import org.itxtech.nemisys.utils.Config;

import java.io.File;
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

    public static String time(long time) {
        int hours = (int) TimeUnit.MILLISECONDS.toHours(time);
        int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(time);
        int seconds = (int) (TimeUnit.MILLISECONDS.toSeconds(time) - minutes * 60);
        return String.valueOf(hours + ":" + minutes + ":" + seconds);
    }
}
