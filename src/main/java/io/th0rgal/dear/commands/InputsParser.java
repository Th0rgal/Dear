package io.th0rgal.dear.commands;

import org.json.simple.JSONObject;

public class InputsParser {

    JSONObject commandAction;
    String inputType;

    public InputsParser(JSONObject commandAction) {

        this.commandAction = commandAction;
        this.inputType = (String) commandAction.get("input_type");

    }

    public Object parse() {
        switch (this.inputType) {
            case "command_no_label":
                return null;
            case "code":
                return commandAction.get("code");
            default:
                return "Wrong input";
        }
    }


}
