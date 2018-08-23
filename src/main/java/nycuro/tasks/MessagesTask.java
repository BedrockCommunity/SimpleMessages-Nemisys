package nycuro.tasks;

import nycuro.SimpleMessagesAPI;
import nycuro.SimpleMessagesMain;
import nycuro.utils.Settings;

import org.itxtech.nemisys.Player;
import org.itxtech.nemisys.scheduler.Task;
import org.itxtech.nemisys.utils.TextFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: NycuRO
 * SimpleMessages Project
 * SimpleMessagesAPI 1.0.0
 */
public class MessagesTask extends Task {

    private Map<String, Integer> timers = new HashMap<>();

    @Override
    public void onRun(int i) {
        List<String> messages = Settings.messages;
        int lenght = messages.toArray().length;
        for (Player player : SimpleMessagesAPI.getMainAPI().getServer().getOnlinePlayers().values()) {
            Integer playerTime = timers.getOrDefault(player.getName(), 0);
            if (playerTime <= (lenght - 1)) {
                String message = messages.get(playerTime);
                message = message.replace("%server_online", String.valueOf(SimpleMessagesAPI.getMainAPI().getServer().getOnlinePlayers().size()));
                message = message.replace("%motd", SimpleMessagesAPI.getMainAPI().getServer().getMotd());
                message = message.replace("%tps", String.valueOf((int) SimpleMessagesAPI.getMainAPI().getServer().getTicksPerSecond()));
                message = message.replace("%server_players", String.valueOf(SimpleMessagesAPI.getMainAPI().getServer().getMaxPlayers()));
                message = message.replace("%tps_averange", String.valueOf((int) SimpleMessagesAPI.getMainAPI().getServer().getTickUsageAverage()));
                message = message.replace("%server_uptime", String.valueOf(SimpleMessagesAPI.getMainAPI().getServer().uptime));
                message = message.replace("&", "§");
                message = message.replace("%time", SimpleMessagesMain.time(System.currentTimeMillis()));
                message = TextFormat.colorize(message);
                player.sendMessage(message);
                timers.put(player.getName(), playerTime + 1);
            } else {
                timers.remove(player.getName());
                timers.put(player.getName(), 0);
            }
        }
    }
}
