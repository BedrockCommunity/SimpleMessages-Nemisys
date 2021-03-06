package nycuro.tasks;

import nycuro.SimpleMessagesAPI;
import nycuro.utils.objects.Mechanic;

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

    private static Map<String, Integer> timers = new HashMap<>();
    private static Map<String, String> placeHolders = new HashMap<>();

    static {
        final Mechanic mechanic = new Mechanic();
        final String timeString = String.valueOf(mechanic.getCountry());
        final TimeZone timeZone = TimeZone.getTimeZone(timeString);
        final Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);
        final int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        final int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        final int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        final int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        final int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        final int milliseconds = calendar.get(Calendar.MILLISECOND);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        final int second = calendar.get(Calendar.SECOND);

        placeHolders.put("%server_online", String.valueOf(SimpleMessagesAPI.getMainAPI().getServer().getOnlinePlayers().size()));
        placeHolders.put("%motd", SimpleMessagesAPI.getMainAPI().getServer().getMotd());
        placeHolders.put("%tps", String.valueOf((int) SimpleMessagesAPI.getMainAPI().getServer().getTicksPerSecond()));
        placeHolders.put("%server_players", String.valueOf(SimpleMessagesAPI.getMainAPI().getServer().getMaxPlayers()));
        placeHolders.put("%tps_averange", String.valueOf((int) SimpleMessagesAPI.getMainAPI().getServer().getTickUsageAverage()));
        placeHolders.put("%server_uptime", String.valueOf(SimpleMessagesAPI.getMainAPI().getServer().uptime));
        placeHolders.put("&", "§");
        placeHolders.put("%time", SimpleMessagesAPI.getMainAPI().time());
        placeHolders.put("%year", String.valueOf(year));
        placeHolders.put("%month", String.valueOf(month));
        placeHolders.put("%hour", String.valueOf(hour));
        placeHolders.put("%minute", String.valueOf(minute));
        placeHolders.put("%second", String.valueOf(second));
        placeHolders.put("%dayOfYear", String.valueOf(dayOfYear));
        placeHolders.put("%dayOfMonth", String.valueOf(dayOfMonth));
        placeHolders.put("%dayOfWeek", String.valueOf(dayOfWeek));
        placeHolders.put("%dayOfWeekInMonth", String.valueOf(dayOfWeekInMonth));
        placeHolders.put("%weekOfMonth", String.valueOf(weekOfMonth));
        placeHolders.put("%weekOfYear", String.valueOf(weekOfYear));
        placeHolders.put("%zoneOffset", String.valueOf(zoneOffset));
        placeHolders.put("%milliseconds", String.valueOf(milliseconds));
    }

    @Override
    public void onRun(int i) {
        List<String> messages = SimpleMessagesAPI.getSettingsAPI().message.getBroadcast();
        int lenght = messages.size();
        for (Player player : SimpleMessagesAPI.getMainAPI().getServer().getOnlinePlayers().values()) {
            int playerTime = timers.getOrDefault(player.getName(), 0);
            if (playerTime <= (lenght - 1)) {
                String message = messages.get(playerTime);
                for (String string : Arrays.asList("%server_online", "%motd", "%tps", "%server_players", "%tps_averange", "%server_uptime", "&",
                        "%time", "%year", "%month", "%hour", "%minute", "%second", "%dayOfYear", "%dayOfMonth", "%dayOfWeek",
                        "%dayOfWeekInMonth", "%weekOfMonth", "%weekOfYear", "%zoneOffset", "%milliseconds"
                )) {
                    if (message.contains(string)) {
                        message = message.replace(string, placeHolders.get(string));
                        message = message.replace("\"", "");
                    }
                }
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
