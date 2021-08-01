package de.byteevolve.gungame.database;

import de.byteevolve.gungame.configuration.config.ConfigEntries;

import java.sql.ResultSet;

public class DatabaseHandler {

    private MySQL mySQL;
    private SQLite sqLite;

    public DatabaseHandler() {
        this.init();;
    }

    public void init(){
        switch (ConfigEntries.DATABASE.getAsString()){
            case "mysql":
                this.mySQL = new MySQL(ConfigEntries.MYSQL_HOST.getAsString(), ConfigEntries.MYSQL_USERNAME.getAsString(),
                        ConfigEntries.MYSQL_PASSWORD.getAsString(), ConfigEntries.MYSQL_DATABASE.getAsString(),
                        ConfigEntries.MYSQL_PORT.getAsInt());
                break;
            case "sqlite":
                this.sqLite = new SQLite();
                this.sqLite.connect();
                break;
        }
    }


    public ResultSet getResult(String qry) {
        switch (ConfigEntries.DATABASE.getAsString()){
            case "mysql":
                return this.mySQL.getResult(qry);
            case "sqlite":
                return this.sqLite.getResult(qry);
        }
        return null;
    }

    public void update(String qry) {
        switch (ConfigEntries.DATABASE.getAsString()){
            case "mysql":
                this.mySQL.update(qry);
            break;
            case "sqlite":
                this.sqLite.update(qry);
            break;
        }
    }


    public void close() {
        switch (ConfigEntries.DATABASE.getAsString()){
            case "mysql":
                if(this.mySQL.isConnected()) {
                    this.mySQL.close();
                }
                break;
            case "sqlite":
                if(this.sqLite.getConnection() != null) {
                    this.sqLite.close();
                }
                break;
        }
    }
}
