package io.th0rgal.dear.listeners;

import io.th0rgal.dear.commands.CommandWrapper;
import io.th0rgal.dear.actions.CommandAction;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;

public class UsersListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String content = event.getMessage().getContentRaw();
        if (content.startsWith(Dear.settings.getPrefix())) {
            String command = content.substring(1);
            String[] args = command.split(" ");
            for (CommandWrapper commandWrapper : Dear.commands) {
                String label = args[0].toLowerCase();
                if (label.equals(commandWrapper.getCommand()) ||
                        Arrays.asList(commandWrapper.getAliases()).contains(label))

                    for (CommandAction action : commandWrapper.getActions()) {
                        action.performActions(event, command, args);
                    }
            }
        }

    }
}