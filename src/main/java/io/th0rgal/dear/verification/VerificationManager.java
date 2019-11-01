package io.th0rgal.dear.verification;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class VerificationManager {

    public static void setDeveloper(boolean accepted, Guild guild, Member member) {
        if (accepted) {
            Role role = guild.getRoleById(588733691463991317L);
            guild.addRoleToMember(member, role).submit();
        }
    }

    public static void setBuyer(boolean accepted, Guild guild, Member member) {
        if (accepted) {
            Role role = guild.getRoleById(564157681804378150L);
            guild.addRoleToMember(member, role).submit();
        }
    }

    public static void setMember(boolean accepted, Guild guild, Member member) {
        if (accepted) {
            Role role = guild.getRoleById(564156869099257879L);
            guild.addRoleToMember(member, role).submit();
        }
    }

}
