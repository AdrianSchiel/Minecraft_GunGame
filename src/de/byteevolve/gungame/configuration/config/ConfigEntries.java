package de.byteevolve.gungame.configuration.config;

import de.byteevolve.gungame.configuration.ConfigEntry;

public enum ConfigEntries implements ConfigEntry {

      //TEMAS COMMAND
    TEAMSIZE(ConfigSections.SETTINGS, "teamsize", 2, 2, "Team Größe ohne Inhaber"),

    MAPCHANGECOUNTER(ConfigSections.SETTINGS, "mapchangecounter", 30, 30,"Zeit wie lange eine Map in Minuten da ist, bis sie gewächselt wird"),

    //LANGUAGE
    LANGUAGE(ConfigSections.SETTINGS, "language", "de_DE", "de_DE", "possible languages: \n de_DE \n en_EN"),

    //SETTINGS
    ANTICROPTRAMPLE(ConfigSections.SETTINGS, "anticroptrample", true, true, "Einstellung um kein Pflanzen zu zertramplen"),
    SCOREBOARD(ConfigSections.SETTINGS, "scoreboard", true, true, "Setting if Scoreboard is enabled."),

    DATABASE(ConfigSections.SETTINGS, "database", "mysql", "mysql", "Which Database Type: \n mysql\n sqlite"),

    //MYSQL
    MYSQL_HOST(ConfigSections.MYSQL, "host", "localhost", "localhost", "Hostname deiner MySQl Datenbank"),
    MYSQL_PASSWORD(ConfigSections.MYSQL, "password", "password", "password", "Passwort deiner MySQl Datenbank"),
    MYSQL_DATABASE(ConfigSections.MYSQL, "database", "gungame", "gungame", "Zu benutzende Datenbank von MySQl"),
    MYSQL_PORT(ConfigSections.MYSQL, "port", 3306, 3306, "Port deiner MySQl Datenbank"),
    MYSQL_USERNAME(ConfigSections.MYSQL, "username", "root", "root", "Username deiner MySQl Datenbank");



    private ConfigSections section;
    private String path,desc;
    private Object value, defaultValue;
    ConfigEntries(ConfigSections section, String path, Object value, Object defaultValue, String desc){
        this.section = section;
        this.path = path;
        this.value = value;
        this.defaultValue = defaultValue;
        this.desc = desc;
    }

    public boolean is(){
        return (boolean) getValue();
    }

    public int getAsInt(){
        return (int) getValue();
    }

    public String getAsString(){
        return getValue().toString().replaceAll("&", "§");
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public ConfigSections getSection() {
        return this.section;
    }

    @Override
    public String getDescription() {
        return this.desc;
    }
}
