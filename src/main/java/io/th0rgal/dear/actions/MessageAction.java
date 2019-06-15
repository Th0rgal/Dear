package io.th0rgal.dear.actions;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MessageAction implements CommandAction {

    private String message;

    @Override
    public void performActions(GuildMessageReceivedEvent event, String command, String[] args) {
        event.getChannel().sendMessage(message).queue();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
