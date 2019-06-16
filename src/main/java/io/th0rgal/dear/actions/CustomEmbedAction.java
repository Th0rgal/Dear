package io.th0rgal.dear.actions;

import io.th0rgal.dear.utils.embeds.EmbedParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.regex.Pattern;

public class CustomEmbedAction implements CommandAction {

    @Override
    public void performActions(GuildMessageReceivedEvent event, String command, String[] args) {

        String embed = command.substring(args[0].length());
        try {
            event.getChannel().sendMessage(new EmbedParser((JSONObject) new JSONParser().parse(embed)).toMessageEmbed()).queue();
        } catch (ParseException e) {
            event.getChannel().sendMessage("Input could not be parsed:" + embed).queue();
        }
    }

}
