package io.th0rgal.dear.commands;

import io.th0rgal.dear.actions.CommandAction;
import io.th0rgal.dear.utils.JSONUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CommandWrapper {

    private String command;
    private String[] aliases;
    private CommandAction[] actions;

    public CommandWrapper(String command, JSONObject jsonObject) {
        this.command = command;
        this.aliases = JSONUtils.toStringArray((JSONArray) jsonObject.get("aliases"));
        this.actions = new ActionsParser((JSONObject) jsonObject.get("actions")).getActions();
    }

    public CommandWrapper(String command, String[] aliases, CommandAction... actions) {
        this.command = command;
        this.aliases = aliases;
        this.actions = actions;
    }

    public String getCommand() {
        return command;
    }

    public String[] getAliases() {
        return aliases;
    }

    public CommandAction[] getActions() {
        return actions;
    }


}
