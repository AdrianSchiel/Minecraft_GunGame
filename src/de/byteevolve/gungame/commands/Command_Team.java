package de.byteevolve.gungame.commands;

import de.byteevolve.gungame.GunGame;
import de.byteevolve.gungame.arena.ArenaTeamState;
import de.byteevolve.gungame.configuration.config.ConfigEntries;
import de.byteevolve.gungame.configuration.language.Message;
import de.byteevolve.gungame.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Command_Team implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            if (GunGame.getInstance().getGameHandler().getCurrent() == null) {
                sender.sendMessage(GunGame.getInstance().getPrefix() + Message.NOARENAEXISTS.getAsString());
                return true;
            }

            if(GunGame.getInstance().getGameHandler().getCurrent().getArenaTeamState().equals(ArenaTeamState.DISALLOWED)){
                sender.sendMessage(GunGame.getInstance().getPrefix() + Message.NOTEAMALLOWED.getAsString());
                return true;
            }
            Player player = (Player) sender;
            if(args.length == 0){
                for(String line : Message.TEAMHELP.getAsString().split("\n")){
                    line = line.replaceAll("\n", "");
                    player.sendMessage(GunGame.getInstance().getPrefix() + line);
                }
                return true;
            }

            switch (args[0].toLowerCase()){
                case "invite":
                    if(args.length == 2) {
                        if (GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString()) != null) {
                            Team team = GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString());
                            if (team.getOwner().equals(player.getUniqueId().toString())) {
                                if(Bukkit.getPlayer(args[1]) != null){
                                    Player toInvite = Bukkit.getPlayer(args[1]);
                                    if(GunGame.getInstance().getTeamHandler().inTeam(toInvite.getUniqueId().toString()) == null) {
                                        if(GunGame.getInstance().getTeamHandler().hasInvite(toInvite.getUniqueId().toString()) != null){
                                            Team inviteTeam = GunGame.getInstance().getTeamHandler().hasInvite(toInvite.getUniqueId().toString());
                                            inviteTeam.getInvites().remove(toInvite.getUniqueId().toString());
                                        }
                                        team.getInvites().add(toInvite.getUniqueId().toString());
                                        toInvite.sendMessage(GunGame.getInstance().getPrefix() + Message.TARGETTEAMINVITE.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERTEAMINVITE.getAsString().replaceAll("%TARGET%", toInvite.getDisplayName()));
                                    }else {
                                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERINTEAM.getAsString());
                                    }
                                } else {
                                    player.sendMessage(GunGame.getInstance().getPlayerNotOnline());
                                }
                            } else {
                                player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERCANTINVITETEAMMEMBER.getAsString());
                                return true;
                            }
                        } else {
                            GunGame.getInstance().getTeamHandler().getTeams().put(player.getUniqueId().toString(), new Team(player.getUniqueId().toString()));
                            Team team = GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString());
                            player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMCREATE.getAsString());
                            if(Bukkit.getPlayer(args[1]) != null){
                                Player toInvite = Bukkit.getPlayer(args[1]);
                                if(GunGame.getInstance().getTeamHandler().inTeam(toInvite.getUniqueId().toString()) == null) {
                                    if(GunGame.getInstance().getTeamHandler().hasInvite(toInvite.getUniqueId().toString()) != null){
                                        Team inviteTeam = GunGame.getInstance().getTeamHandler().hasInvite(toInvite.getUniqueId().toString());
                                        inviteTeam.getInvites().remove(toInvite.getUniqueId().toString());
                                    }
                                    team.getInvites().add(toInvite.getUniqueId().toString());
                                    toInvite.sendMessage(GunGame.getInstance().getPrefix() + Message.TARGETTEAMINVITE.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                                    player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERTEAMINVITE.getAsString().replaceAll("%TARGET%", toInvite.getDisplayName()));
                                }else {
                                    player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERINTEAM.getAsString());
                                }
                            } else {
                                player.sendMessage(GunGame.getInstance().getPlayerNotOnline());
                            }
                        }
                    }else {
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMINVITEHELP.getAsString());
                    }
                    break;
                case "accept":
                    if(GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString()) == null) {
                        if (GunGame.getInstance().getTeamHandler().hasInvite(player.getUniqueId().toString()) != null) {
                            Team team = GunGame.getInstance().getTeamHandler().hasInvite(player.getUniqueId().toString());
                            if (team.getMembers().size() <= ConfigEntries.TEAMSIZE.getAsInt()) {
                                team.getInvites().remove(player.getUniqueId().toString());
                                team.getMembers().add(player.getUniqueId().toString());
                                for(String uuid : team.getMembers()){
                                    Player member = Bukkit.getPlayer(UUID.fromString(uuid));
                                    member.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMJOIN.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                                }
                                Player owner = Bukkit.getPlayer(UUID.fromString(team.getOwner()));
                                owner.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMJOIN.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                                player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMJOINPLAYER.getAsString().replaceAll("%OWNER%", owner.getDisplayName()));
                            } else {
                                player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMFULL.getAsString());
                                team.getInvites().remove(player.getUniqueId().toString());
                            }
                        } else {
                            player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERHASNOTEAMINVITE.getAsString());
                        }
                    }else{
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERISINTEAM.getAsString());
                    }
                    break;
                case "deny":
                    if(GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString()) == null) {
                        if (GunGame.getInstance().getTeamHandler().hasInvite(player.getUniqueId().toString()) != null) {
                            Team team = GunGame.getInstance().getTeamHandler().hasInvite(player.getUniqueId().toString());
                            team.getInvites().remove(player.getUniqueId().toString());
                            Player owner = Bukkit.getPlayer(UUID.fromString(team.getOwner()));
                            owner.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMDENYOWNER.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                            player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMDENYPLAYER.getAsString().replaceAll("%OWNER%", owner.getDisplayName()));
                        } else {
                            player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERHASNOTEAMINVITE.getAsString());
                        }
                    }else{
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERISINTEAM.getAsString());
                    }
                    break;
                case "info":
                    if(GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString()) != null){
                        Team team = GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString());
                        Player owner = Bukkit.getPlayer(UUID.fromString(team.getOwner()));
                        player.sendMessage(GunGame.getInstance().getPrefix() +"§7§m§l-------------------------------------");
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMINFOOWNER.getAsString().replaceAll("%OWNER%", owner.getDisplayName()));
                        for(String uuid : team.getMembers()){
                            Player member = Bukkit.getPlayer(UUID.fromString(uuid));
                            player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMINFOMEMBER.getAsString().replaceAll("%MEMBER%", member.getDisplayName()));
                        }
                        player.sendMessage(GunGame.getInstance().getPrefix() +"§7§m§l-------------------------------------");
                    }else {
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERNOTEAM.getAsString());
                    }
                    break;
                case "leave":
                    if(GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString()) != null){
                        Team team = GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString());
                        if(team.getOwner().equals(player.getUniqueId().toString())){
                            if(team.getMembers().size() > 0) {
                                String newOwner = team.getMembers().get(0);
                                team.setOwner(newOwner);
                                team.getMembers().remove(newOwner);
                                Bukkit.getPlayer(UUID.fromString(newOwner)).sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMNEWOWNER.getAsString());
                                GunGame.getInstance().getTeamHandler().getTeams().remove(player.getUniqueId().toString());
                                GunGame.getInstance().getTeamHandler().getTeams().put(newOwner, team);
                            }else{
                                GunGame.getInstance().getTeamHandler().getTeams().remove(player.getUniqueId().toString());
                                player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMDELETE.getAsString());
                                return true;
                            }
                        }else{
                            team.getMembers().remove(player.getUniqueId().toString());
                        }

                        for(String uuid : team.getMembers()){
                            Player member = Bukkit.getPlayer(UUID.fromString(uuid));
                            member.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMLEAVEMEMBER.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                        }
                        Player owner = Bukkit.getPlayer(UUID.fromString(team.getOwner()));
                        owner.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMLEAVEMEMBER.getAsString().replaceAll("%PLAYER%", player.getDisplayName()));
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMLEAVEPLAYER.getAsString().replaceAll("%OWNER%", owner.getDisplayName()));
                    }else {
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERNOTEAM.getAsString());
                    }
                    break;
                case "kick":
                    if(args.length == 2) {
                        if (GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString()) != null) {
                            Team team = GunGame.getInstance().getTeamHandler().inTeam(player.getUniqueId().toString());
                            if (team.getOwner().equals(player.getUniqueId().toString())) {
                                if(Bukkit.getPlayer(args[1]) != null){
                                    Player toKick = Bukkit.getPlayer(args[1]);
                                    if(team.getMembers().contains(toKick.getUniqueId().toString())){
                                        team.getMembers().remove(toKick.getUniqueId().toString());
                                        toKick.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMKICKPLAYER.getAsString().replaceAll("%OWNER%", player.getDisplayName()));
                                        for(String uuid : team.getMembers()){
                                            Player member = Bukkit.getPlayer(UUID.fromString(uuid));
                                            member.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMLEAVEMEMBER.getAsString().replaceAll("%PLAYER%", toKick.getDisplayName()));
                                        }
                                        Player owner = Bukkit.getPlayer(UUID.fromString(team.getOwner()));
                                        owner.sendMessage(GunGame.getInstance().getPrefix() +  Message.TEAMLEAVEMEMBER.getAsString().replaceAll("%PLAYER%", toKick.getDisplayName()));
                                    }else{
                                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMPLAYERNOTATTEAM.getAsString().replaceAll("%PLAYER%", toKick.getDisplayName()));
                                    }
                                }else{
                                    player.sendMessage(GunGame.getInstance().getPlayerNotOnline());
                                }
                            } else {
                                player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMNOPERMTOKICK.getAsString());
                            }
                        } else {
                            player.sendMessage(GunGame.getInstance().getPrefix() + Message.PLAYERNOTEAM.getAsString());
                        }
                    }else {
                        player.sendMessage(GunGame.getInstance().getPrefix() + Message.TEAMKICKHELP.getAsString());
                    }
                    break;
                default:
                    for(String line : Message.TEAMHELP.getAsString().split("\n")){
                        player.sendMessage(GunGame.getInstance().getPrefix() + line);
                    }
                    break;
            }

        }else sender.sendMessage(GunGame.getInstance().getMustAPlayer());
        return true;
    }
}
