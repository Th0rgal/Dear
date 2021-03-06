package io.th0rgal.dear.commands;

import io.th0rgal.dear.actions.*;

import io.th0rgal.dear.utils.embeds.EmbedParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ActionsParser {

    private CommandAction[] commandActions;

    public ActionsParser(JSONArray actions) {
        commandActions = new CommandAction[actions.size()];
        int iterator = 0;
        for (Object actionSection : actions) {
            JSONObject actionJson = (JSONObject)actionSection;
            String type = (String)actionJson.get("type");
            JSONParser jsonParser = new JSONParser();

            switch (type) {

                case "message":
                    MessageAction messageAction = new MessageAction();
                    messageAction.setMessage((String)actionJson.get("content"));
                    commandActions[iterator] = messageAction;
                    break;

                case "rank":
                    RankAction rankAction = new RankAction();
                    commandActions[iterator] = rankAction;
                    break;

                case "embed":
                    EmbedAction embedAction = new EmbedAction();
                    embedAction.setMessage(new EmbedParser((JSONObject)actionJson.get("content")).toMessageEmbed());
                    commandActions[iterator] = embedAction;
                    break;

                case "custom_embed":
                    CustomEmbedAction customEmbedAction = new CustomEmbedAction();
                    commandActions[iterator] = customEmbedAction;
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
