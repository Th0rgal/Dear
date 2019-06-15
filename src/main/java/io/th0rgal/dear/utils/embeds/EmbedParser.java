package io.th0rgal.dear.utils.embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EmbedParser {

    private JSONObject jsonEmbed;

    public EmbedParser(JSONObject jsonEmbed) {
        this.jsonEmbed = jsonEmbed;
    }

    public MessageEmbed toMessageEmbed() {
        Set keys = jsonEmbed.keySet();
        EmbedBuilder embedBuilder = new EmbedBuilder();

        if (keys.contains("title"))
            if (keys.contains("url"))
                embedBuilder.setTitle((String) jsonEmbed.get("title"), (String) jsonEmbed.get("url"));
            else
                embedBuilder.setTitle((String) jsonEmbed.get("title"));

        if (keys.contains("description"))
            embedBuilder.setDescription((String) jsonEmbed.get("description"));

        if (keys.contains("color"))
            embedBuilder.setColor(Math.toIntExact((long) jsonEmbed.get("color")));

        if (keys.contains("timestamp"))
            embedBuilder.setTimestamp(DateTimeFormatter.ISO_DATE_TIME.parse((String) jsonEmbed.get("timestamp")));

        if (keys.contains("footer")) {
            JSONObject footer = (JSONObject) jsonEmbed.get("footer");
            if (footer.keySet().contains("icon_url"))
                embedBuilder.setFooter((String) footer.get("text"), (String) footer.get("icon_url"));
            else
                embedBuilder.setFooter((String) footer.get("text"));
        }

        if (keys.contains("thumbnail"))
            embedBuilder.setThumbnail((String) ((JSONObject) jsonEmbed.get("thumbnail")).get("url"));

        if (keys.contains("image"))
            embedBuilder.setImage((String) ((JSONObject) jsonEmbed.get("image")).get("url"));

        if (keys.contains("author")) {
            JSONObject author = (JSONObject) jsonEmbed.get("author");
            if (!author.keySet().contains("icon_url") && !author.keySet().contains("url"))
                embedBuilder.setAuthor((String) author.get("name"));
            else if (!author.keySet().contains("icon_url"))
                embedBuilder.setAuthor((String) author.get("name"), (String) author.get("url"));
            else
                embedBuilder.setAuthor((String) author.get("name"), (String) author.get("url"), (String) author.get("icon_url"));
        }

        if (keys.contains("fields")) {
            JSONArray fields = (JSONArray) jsonEmbed.get("fields");
            for (Object objectField : fields) {
                JSONObject jsonField = (JSONObject) objectField;
                String fieldName = (String) jsonField.get("name");
                String fieldValue = (String) jsonField.get("value");
                boolean inline = false;
                if (jsonField.keySet().contains("inline"))
                    inline = (boolean) jsonField.get("inline");
                embedBuilder.addField(fieldName, fieldValue, inline);
            }
        }

        return embedBuilder.build();

    }

}
