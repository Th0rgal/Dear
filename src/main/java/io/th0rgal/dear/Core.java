package io.th0rgal.dear;

import io.th0rgal.dear.listeners.Dear;
import io.th0rgal.dear.listeners.UsersListener;
import io.th0rgal.dear.utils.ConfigurationFilesUtils;

import net.dv8tion.jda.api.JDABuilder;
import org.json.simple.parser.ParseException;

import javax.security.auth.login.LoginException;
import java.io.*;


public class Core {

    public static void main(String[] args) throws IOException, LoginException, ParseException {

        //loading configurations
        ConfigurationFilesUtils.loadSettings();
        ConfigurationFilesUtils.loadCommands();

        //loading JDA
        Dear.api = new JDABuilder(Dear.settings.getToken()).build();
        Dear.api.addEventListener(new UsersListener());

    }


}
