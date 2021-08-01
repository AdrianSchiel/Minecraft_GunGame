package de.byteevolve.gungame.database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

import de.byteevolve.gungame.GunGame;
import de.byteevolve.gungame.logger.LogTypes;
import de.byteevolve.gungame.logger.Logger;
import org.bukkit.Bukkit;

public class SQLite {

    public Connection con;

    public SQLite() {

    }

    public void connect() {
        con = getConnection();
        update("CREATE TABLE IF NOT EXISTS `gg_stats` (`UUID` text NOT NULL,`NAME` text NOT NULL,`KILLS` int(11) NOT NULL," +
                "`DEATHS` int(11) NOT NULL,`HIGHSCORE` int(11) NOT NULL, `POINTS` int(11) NOT NULL);");
        update("CREATE TABLE IF NOT EXISTS `gg_arena` ( `NAME` TEXT NOT NULL , `DISPLAYNAME` TEXT NOT NULL , `SPAWN` TEXT NOT NULL ," +
                " `MAXSPAWN` TEXT NOT NULL , `MINSPAWN` TEXT NOT NULL , `TEAMSTATE` TEXT NOT NULL, `FINISHED` INT NOT NULL);");
        update("CREATE TABLE IF NOT EXISTS `gg_locs` (`NAME` text NOT NULL,`X` double NOT NULL,`Y` double NOT NULL," +
                "  `Z` double NOT NULL,`YAW` float NOT NULL, `PITCH` float NOT NULL,`WORLD` text NOT NULL);");
        Logger.log(LogTypes.SUCCESS, "Erfolgreich zur SQLite-Datenbank verbunden.");
    }

    public void close(PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            Logger.log(LogTypes.ERROR, "Verbindung zur SQLite-Datenbank konnte nicht geschlossen werden.");
        }
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            Logger.log(LogTypes.ERROR, "Verbindung zur SQLite-Datenbank konnte nicht geschlossen werden.");
        }
    }

    public void update(String qre) {
            try {
                con = getConnection();
                PreparedStatement st = con.prepareStatement(qre);
                st.executeUpdate();
                st.close();
                close();
            } catch (SQLException e) {
                System.err.print(e);
            }
    }

    public ResultSet getResult(String qre) {
        con = getConnection();
        if (con != null) {
            ResultSet rs = null;
            try {
                PreparedStatement st = con.prepareStatement(qre);
                rs = st.executeQuery();
            } catch (SQLException e) {
                System.err.print(e);
            }
            return rs;
        }
        return null;
    }

    public Connection getConnection() {
        File dataFolder = new File("plugins/GunGame/", "gungame.db");
        if (!dataFolder.exists()) {
            try {
                dataFolder.createNewFile();
            } catch (IOException e) {
                Logger.log(LogTypes.ERROR, "Konnte SQLite-Datenbank nicht erstellen.");
            }
        }
        try {
            if (con != null && !con.isClosed()) {
                return con;
            }
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + dataFolder);
            return con;
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
            GunGame.getInstance().getLogger().log(Level.SEVERE, "You need the SQLite JBDC library. Google it. Put it in /lib folder.");
        }
        return null;
    }
}
