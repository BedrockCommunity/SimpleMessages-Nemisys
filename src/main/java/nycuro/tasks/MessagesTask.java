package nycuro.tasks;

import nycuro.SimpleMessagesAPI;
import nycuro.SimpleMessagesMain;
import nycuro.utils.Settings;

import org.itxtech.nemisys.Player;
import org.itxtech.nemisys.scheduler.Task;
import org.itxtech.nemisys.utils.TextFormat;

import java.util.*;

/**
 * author: NycuRO
 * SimpleMessages Project
 * SimpleMessagesAPI 1.0.0
 */
public class MessagesTask extends Task {

    private Map<String, Integer> timers = new HashMap<>();

    @Override
    public void onRun(int i) {
        Object timeValue = Settings.mechanic.toArray()[2];
        String timeString = String.valueOf(timeValue);
        TimeZone timeZone = TimeZone.getTimeZone(timeString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        int milliseconds = calendar.get(Calendar.MILLISECOND);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

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
                message = message.replace("%time", SimpleMessagesMain.time());
                message = message.replace("%year", String.valueOf(year));
                message = message.replace("%month", String.valueOf(month));
                message = message.replace("%hour", String.valueOf(hour));
                message = message.replace("%minute", String.valueOf(minute));
                message = message.replace("%second", String.valueOf(second));
                message = message.replace("%dayOfYear", String.valueOf(dayOfYear));
                message = message.replace("%dayOfMonth", String.valueOf(dayOfMonth));
                message = message.replace("%dayOfWeek", String.valueOf(dayOfWeek));
                message = message.replace("%dayOfWeekInMonth", String.valueOf(dayOfWeekInMonth));
                message = message.replace("%weekOfMonth", String.valueOf(weekOfMonth));
                message = message.replace("%weekOfYear", String.valueOf(weekOfYear));
                message = message.replace("%zoneOffset", String.valueOf(zoneOffset));
                message = message.replace("%milliseconds", String.valueOf(milliseconds));
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
