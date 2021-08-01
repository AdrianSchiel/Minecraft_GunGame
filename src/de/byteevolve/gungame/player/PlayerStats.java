package de.byteevolve.gungame.player;

import de.byteevolve.gungame.GunGame;
import de.byteevolve.gungame.database.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerStats {

    private String uuid;

    public PlayerStats(String uuid) {
        this.uuid = uuid;
        this.create();
    }

    private boolean exists() {
        try {
            ResultSet resultSet = GunGame.getInstance().getDatabaseHandler().getResult("SELECT * FROM gg_stats WHERE gg_stats.UUID='" + getUUID() +"';");
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void create() {
        if(!exists()) {
            GunGame.getInstance().getDatabaseHandler().update("INSERT INTO gg_stats VALUES('" +getUUID() +"', '"+ getName() +"',"
                        + "'0', '0', '0', '0');");
        }
    }


    public double getKD() {
        double deaths = get(PlayerStatsType.DEATHS);
        double kills = get(PlayerStatsType.KILLS);
        double kd = kills / deaths;
        return Math.round(kd * 100.0D) / 100.0D;
    }

    public Integer get(PlayerStatsType type) {

        try {
            ResultSet resultSet = GunGame.getInstance().getDatabaseHandler().getResult("SELECT " +type.toString() +" FROM gg_stats WHERE gg_stats.UUID='" + getUUID() +"';");
            if(resultSet.next()) return resultSet.getInt(type.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    public void add(PlayerStatsType type, int value) {
        set(type ,get(type) + value);
    }
    public void remove(PlayerStatsType type, int value) {
        if(get(type)- value <= 0){
            set(type,0);
        }else set(type ,get(type) - value);
    }

    public void set(PlayerStatsType type, int value) {
        if(exists()) {
            GunGame.getInstance().getDatabaseHandler().update("UPDATE gg_stats SET " + type.toString() + "='" + value+ "' WHERE UUID='" + getUUID() + "';");
        }else create();
    }


    private String getName() {
        return Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
    }
    private String getUUID() {
        return this.uuid;
    }

    public Integer getRank() {
        HashMap<Integer, String> rang = new HashMap<>();
        try {
            ResultSet rs = GunGame.getInstance().getDatabaseHandler().getResult("SELECT UUID FROM gg_stats ORDER BY POINTS DESC LIMIT 1000");
            int in = 0;
            try {
                while (rs.next()) {
                    in++;
                    if (rs.getString("UUID").equalsIgnoreCase(uuid))
                        return Integer.valueOf(in);
                    if (in == 1000)
                        return Integer.valueOf(-1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception exception) {}
        return null;
    }


}
