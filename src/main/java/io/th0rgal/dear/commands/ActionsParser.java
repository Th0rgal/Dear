package io.th0rgal.dear.commands;

import io.th0rgal.dear.actions.CommandAction;
import io.th0rgal.dear.actions.EmbedAction;
import io.th0rgal.dear.actions.MessageAction;

import io.th0rgal.dear.utils.embeds.EmbedParser;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.json.simple.JSONObject;

public class ActionsParser {

    private CommandAction[] commandActions;

    public ActionsParser(JSONObject actions) {
        commandActions = new CommandAction[actions.keySet().size()];
        int iterator = 0;
        for (Object actionSection : actions.keySet()) {
            String actionName = (String) actionSection;
            Object action = actions.get(actionSection);

            switch (actionName) {

                case "message":
                    MessageAction messageAction = new MessageAction();
                    messageAction.setMessage((String)action);
                    commandActions[iterator] = messageAction;
                    break;

                case "embed":
                    EmbedAction embedAction = new EmbedAction();
                    embedAction.setMessage(new EmbedParser((JSONObject)action).toMessageEmbed());
                    commandActions[iterator] = embedAction;
                    break;

                default:
                    break;
            }

        }
    }

    public CommandAction[] getActions() {
        return this.commandActions;
    }

}
