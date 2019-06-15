package io.th0rgal.dear.actions;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface CommandAction {

    void performActions(GuildMessageReceivedEvent event, String command, String[] args);

}
