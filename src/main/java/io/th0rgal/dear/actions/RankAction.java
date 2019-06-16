package io.th0rgal.dear.actions;

import io.th0rgal.dear.utils.embeds.EmbedUtils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RankAction implements CommandAction {

    @Override
    public void performActions(GuildMessageReceivedEvent event, String command, String[] args) {
        Guild guild = event.getGuild();

        switch (args[1].toLowerCase()) {

            case "developer":

                guild.addRoleToMember(event.getMember(), guild.getRoleById(588733691463991317L)).submit();
                break;

            default:
                event.getChannel().sendMessage(EmbedUtils.getEmbedFormating("The requested rank doesn't exist")).queue();
                return;
        }
        event.getChannel().sendMessage(EmbedUtils.getEmbedFormating("You successfully received your rank")).queue();
    }

}
