package io.th0rgal.dear.listeners;

import io.th0rgal.dear.Settings;
import io.th0rgal.dear.commands.CommandWrapper;
import net.dv8tion.jda.api.JDA;

import java.util.ArrayList;
import java.util.List;

public class Dear {

    public static JDA api;
    public static Settings settings;
    public static List<CommandWrapper> commands = new ArrayList<>();

}
