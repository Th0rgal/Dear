package io.th0rgal.dear.listeners;

import io.th0rgal.dear.commands.CommandWrapper;
import io.th0rgal.dear.actions.CommandAction;
import io.th0rgal.dear.verification.VerificationManager;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
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

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

        boolean accepted = 9989 == (int) event.getReactionEmote().getName().toCharArray()[0];

        switch (event.getMessageId()) {

            case "610760299552964608":
                VerificationManager.setDeveloper(accepted, event.getGuild(), event.getMember());
                break;

            case "610760475545698304":
                VerificationManager.setBuyer(accepted, event.getGuild(), event.getMember());
                break;

            case "610761804309725197":
                VerificationManager.setMember(accepted, event.getGuild(), event.getMember());
                break;

            default:
        }


    }
}