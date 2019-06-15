package io.th0rgal.dear.utils;

import io.th0rgal.dear.Core;
import io.th0rgal.dear.Settings;
import io.th0rgal.dear.commands.CommandWrapper;
import io.th0rgal.dear.listeners.Dear;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConfigurationFilesUtils {

    public static void loadSettings() throws IOException, ParseException {
        //generating settings from settings.json
        JSONObject settings = parseResource("/settings.json");
        Dear.settings = new Settings((String) settings.get("token"), (String) settings.get("prefix"));
    }

    public static void loadCommands() throws IOException, ParseException {
        //generating settings from settings.json
        JSONObject commands = parseResource("/commands.json");
        //parsing commands from json using CommandWrapper
        for (Object command : commands.keySet())
            Dear.commands.add(new CommandWrapper((String) command, (JSONObject) commands.get(command)));
    }

    private static JSONObject parseResource(String fileName) throws IOException, ParseException {
        InputStreamReader inputStreamReader = new InputStreamReader(Core.class.getResource(fileName).openStream(), StandardCharsets.UTF_8);
        return (JSONObject) new JSONParser().parse(inputStreamReader);
    }

}
