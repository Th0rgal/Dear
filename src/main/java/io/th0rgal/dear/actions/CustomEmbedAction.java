package io.th0rgal.dear.actions;

import io.th0rgal.dear.utils.embeds.EmbedParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CustomEmbedAction implements CommandAction {

    @Override
    public void performActions(GuildMessageReceivedEvent event, String command, String[] args) {
        //remove the label of the command and the first space
        String input = command.substring(args[0].length() + 1);
        try {
            String code = input.split("```")[1].replace("json", "");

            try {
                event.getChannel().sendMessage(new EmbedParser((JSONObject) new JSONParser().parse(code)).toMessageEmbed()).queue();
            } catch (ParseException e) {
                event.getChannel().sendMessage("Input could not be parsed:```" + code + "```").queue();
            }
        } catch (Exception exception) {
            event.getChannel().sendMessage("Wrong input:```" + input + "```").queue();
        }
    }

}
