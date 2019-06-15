package io.th0rgal.dear.actions;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class EmbedAction implements CommandAction {

    private MessageEmbed message;

    @Override
    public void performActions(GuildMessageReceivedEvent event, String command, String[] args) {
        event.getChannel().sendMessage(message).queue();
    }

    public void setMessage(MessageEmbed message) {
        this.message = message;
    }
}
