package nycuro.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import nycuro.SimpleMessagesAPI;
import nycuro.utils.objects.JsonObject;
import nycuro.utils.objects.Mechanic;
import nycuro.utils.objects.Message;

import java.io.*;
import java.util.*;

/**
 * author: NycuRO
 * SimpleMessages-Nemisys Project
 * API 1.0.0
 */
public class Settings {

    public static void init() {
        try {
            File file = new File(SimpleMessagesAPI.getMainAPI().getDataFolder(), "config.json");
            if (!file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(serializeData());
                fileWriter.close();
            } else {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode settings = mapper.reader().readTree(new FileReader(file));
                JsonNode jsonNodeMessages = settings.get("messages").get("broadcast");
                JsonNode jsonNodeMechanic = settings.get("mechanic");

                Mechanic mechanic = new Mechanic();
                mechanic.setPeriod(Integer.valueOf(jsonNodeMechanic.get("period").toString()));
                mechanic.setAsync(Boolean.getBoolean(jsonNodeMechanic.get("async").toString()));
                mechanic.setCountry(jsonNodeMechanic.get("country").toString());

                if (jsonNodeMessages.isArray()) {
                    for (final JsonNode objNode : jsonNodeMessages) {
                        List<String> strings = new ArrayList<>();
                        strings.add(objNode.toString());
                        Message message = new Message();
                        message.setBroadcast(strings);
                        System.out.println("Finished");
                        System.out.println(message.toString());
                    }
                }
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private static String serializeData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonObject json = new JsonObject();
        Mechanic mechanic = new Mechanic();
        mechanic.setAsync(true);
        mechanic.setCountry("Europe/Bucharest");
        mechanic.setPeriod(5);

        Message message = new Message();
        List<String> messages = Arrays.asList(
                "&7Hello players! Now is %server_online players!",
                "&eNow is %time",
                "&6Thanks for playing on that server!",
                "&cHave fun guys! %motd");

        message.setBroadcast(messages);

        json.setMechanic(mechanic);
        json.setMessages(message);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }
}
