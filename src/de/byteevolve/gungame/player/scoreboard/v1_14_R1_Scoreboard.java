package de.byteevolve.gungame.player.scoreboard;

import de.byteevolve.gungame.GunGame;
import de.byteevolve.gungame.configuration.config.ConfigEntries;
import de.byteevolve.gungame.configuration.language.Message;
import de.byteevolve.gungame.player.PlayerStats;
import de.byteevolve.gungame.player.PlayerStatsType;
import net.minecraft.server.v1_14_R1.*;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class v1_14_R1_Scoreboard implements GGScoreboard{

    @Override
    public void sendScoreboard(Player player) {
        Scoreboard sb = new Scoreboard();
        ScoreboardObjective obj = sb.registerObjective(Message.SCOREBOARDNAME.getAsString(), IScoreboardCriteria.DUMMY, new ChatMessage(Message.SCOREBOARDNAME.getAsString()), IScoreboardCriteria.EnumScoreboardHealthDisplay.INTEGER);
        PacketPlayOutScoreboardObjective createpacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        obj.setDisplayName(new ChatMessage(Message.SCOREBOARDNAME.getAsString()));

        PlayerStats playerStats = new PlayerStats(player.getUniqueId().toString());

        String map;
        if(GunGame.getInstance().getGameHandler().getCurrent() != null) {
            map = GunGame.getInstance().getGameHandler().getCurrent().getDisplayname().replaceAll("&", "§");
        } else map = "-";

        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        sendPacket(removePacket, player);
        sendPacket(createpacket, player);
        sendPacket(display, player);

        int i = 16;
        for(String line : Message.SCOREBOARD.getAsString().split("\n")){
            line = line.replaceAll("%MAP%", map);
            line = line.replaceAll("%RECORD%", String.valueOf(playerStats.get(PlayerStatsType.HIGHSCORE)));
            line = line.replaceAll("%KILLS%", String.valueOf(playerStats.get(PlayerStatsType.KILLS)));
            line = line.replaceAll("%DEATHS%", String.valueOf(playerStats.get(PlayerStatsType.DEATHS)));
            line = line.replaceAll("%RANK%", String.valueOf(playerStats.getRank()));
            line = line.replaceAll("%KD%", String.valueOf(playerStats.getKD()));

            PacketPlayOutScoreboardScore packet= new PacketPlayOutScoreboardScore(ScoreboardServer.Action.CHANGE,Message.SCOREBOARDNAME.getAsString(),line,i);
            sendPacket(packet, player);

            i--;
        }
    }
    public void sendPacket(Packet<?> packet, Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
