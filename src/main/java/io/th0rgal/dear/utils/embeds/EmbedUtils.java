package io.th0rgal.dear.utils.embeds;

import io.th0rgal.dear.listeners.Dear;

import net.dv8tion.jda.api.entities.MessageEmbed;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmbedUtils {

    public static MessageEmbed getEmbedFormating(String message) {
        try {
            return new EmbedParser((JSONObject) new JSONParser().parse(Dear.settings.getEmbedTemplate().toString().replace("%message%", message))).toMessageEmbed();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}