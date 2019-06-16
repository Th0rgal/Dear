package io.th0rgal.dear.actions;

import io.th0rgal.dear.utils.embeds.EmbedUtils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RankAction implements CommandAction {

    @Override
    public void performActions(GuildMessageReceivedEvent event, String command, String[] args) {
        Guild guild = event.getGuild();

        String message = "You successfully received your rank";

        switch (args[1].toLowerCase()) {

            case "developer":
                Role role = guild.getRoleById(588733691463991317L);
                if (guild.getMembersWithRoles(role).contains(event.getMember())) {
                    guild.removeRoleFromMember(event.getMember(), role).submit();
                    message = "The role has been successfully removed";
                } else {
                    guild.addRoleToMember(event.getMember(), role).submit();
                }
                break;

            default:
                message = "The requested rank doesn't exist";
                break;
        }
        event.getChannel().sendMessage(EmbedUtils.getEmbedFormating(message)).queue();
    }

}
