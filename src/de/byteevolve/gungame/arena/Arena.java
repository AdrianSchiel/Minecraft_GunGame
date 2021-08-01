package de.byteevolve.gungame.arena;

import de.byteevolve.gungame.GunGame;
import de.byteevolve.gungame.configuration.language.Message;
import de.byteevolve.gungame.game.GameHandler;
import de.byteevolve.gungame.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Arena dient zum erstellen eigener Maps für das Gungame System.
 * @author RoyalByte | Adrian Schiel
 * @since 0.1
 * @version 1.0
 * @see ArenaHandler
 */

public class Arena {

    private String name, spawn, minSpawn, maxSpawn, displayname;
    private ArenaTeamState arenaTeamState;
    private int finished;

    /**
     * Konstruktor für die Klasse {@link Arena}
     * @param name der Name der Arena
     */
    public Arena(String name) {
        this.name = name;
    }

    /**
     * Speichert die Arena in der SQL Datenbank
     */
    public void update(){
        if(getArenaTeamState() == null) setArenaTeamState(ArenaTeamState.DISALLOWED);
        if(getSpawn() == null) setSpawn("");
        if(getMinSpawn() == null) setMinSpawn("");
        if(getMaxSpawn() == null) setMaxSpawn("");
        if(getDisplayname() == null) setDisplayname("");
        if (GunGame.getInstance().getArenaHandler().existArenaByName(getName())) {
            GunGame.getInstance().getMySQL().update("UPDATE gg_arena SET " +
                    "DISPLAYNAME='" +getDisplayname() +"', SPAWN='" + getSpawn()+ "',"+
                    "MAXSPAWN='" + getMaxSpawn()+"', MINSPAWN='" + getMinSpawn()+"',"+
                    "TEAMSTATE='" +getArenaTeamState().toString()+ "', FINISHED='" + getFinished() +"' WHERE NAME='" + getName()+"';");
            GunGame.getInstance().getArenaHandler().loadArenas();
        } else {
            GunGame.getInstance().getMySQL().update("INSERT INTO gg_arena VALUES('" +getName() +"', '" + getDisplayname()+"','" +
                   getSpawn() +"', '" +getMaxSpawn() +"', '" + getMinSpawn() +"', '" + getArenaTeamState().toString()+"', '1');");
            GunGame.getInstance().getArenaHandler().loadArenas();
        }
    }

    public void delete(){
        GunGame.getInstance().getLocationHandler().getLocByName(getSpawn()).delete();
        GunGame.getInstance().getLocationHandler().getLocByName(getMinSpawn()).delete();
        GunGame.getInstance().getLocationHandler().getLocByName(getMaxSpawn()).delete();

        GunGame.getInstance().getMySQL().update("DELETE FROM gg_arena WHERE NAME='" + getName() +"';");


        if(GunGame.getInstance().getGameHandler().getCurrent().getName().equalsIgnoreCase(getName())){
            GunGame.getInstance().getArenaHandler().loadArenas();
            if(!GunGame.getInstance().getArenaHandler().getArenas().isEmpty()){
                GunGame.getInstance().getGameHandler().setCurrent(GunGame.getInstance().getArenaHandler().getArenas().get(0));
            }else GunGame.getInstance().getGameHandler().setCurrent(null);

            for (Player player : Bukkit.getOnlinePlayers()) {
                if (GunGame.getInstance().getGameHandler().getCurrent() != null) {
                    player.teleport(GunGame.getInstance().getLocationHandler().getLocByName(GunGame.getInstance().getGameHandler().getCurrent().getSpawn()).getAsLocation());
                } else {
                    player.sendMessage(GunGame.getInstance().getPrefix() + Message.NOARENAEXISTS.getAsString());
                }
                GunGame.getInstance().getGameHandler().getPlayerkits().put(player, Kit.LEVEL_0);
                GunGame.getInstance().getGameHandler().getPlayerkits().get(player).getKitInventory().load(player);

                GunGame.getInstance().setGameHandler(new GameHandler());
            }
        }else{
            GunGame.getInstance().getArenaHandler().loadArenas();

        }

    }

    /**
     * Liefert einen Boolean, ob ein eine Location am Spawn ist
     * @param location die Location welche abgefragt wird
     * @return boolean, ob eine Location sich am spawn befindet.
     */
    public boolean atSpawn(Location location){
        Location min = GunGame.getInstance().getLocationHandler().getLocByName(this.minSpawn).getAsLocation();
        Location max = GunGame.getInstance().getLocationHandler().getLocByName(this.maxSpawn).getAsLocation();
        if(min.getWorld().getName() == max.getWorld().getName()){
            if(location.getWorld().getName() == min.getWorld().getName()){
                if((location.getBlockX() >= min.getBlockX() && location.getBlockX() <= max.getBlockX()) || (location.getBlockX() <= min.getBlockX() && location.getBlockX() >= max.getBlockX())){
                    if((location.getBlockZ() >= min.getBlockZ() && location.getBlockZ() <= max.getBlockZ()) || (location.getBlockZ() <= min.getBlockZ() && location.getBlockZ() >= max.getBlockZ())){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Liefert den {@link ArenaState} über die ID des states
     * @param state ID des ArenaStates
     * @return ArenaState welcher ermittelt wird
     */
    public ArenaState getArenaStateFromInt(int state){
        switch (state){
            case 1:
                return ArenaState.FINISHED;
            default:
                return ArenaState.UNFINISHED;
        }
    }

    /**
     * Liefert den Status der Arena
     * @return Status der Arena
     */
    public int getFinished() {
        return finished;
    }

    /**
     * Setzt den Status der Arena
     * @param finished neuer Status der Arena
     */
    public void setFinished(int finished) {
        this.finished = finished;
    }

    /**
     * Gibt den TeamStatus der Arena wieder (Teams erlaubt, Teams verboten)
     * @return TeamStatus
     */
    public ArenaTeamState getArenaTeamState() {
        return arenaTeamState;
    }

    /**
     * Setzt den TeamStatus der Arena
     * @param arenaTeamState neuer TeamState
     */
    public void setArenaTeamState(ArenaTeamState arenaTeamState) {
        this.arenaTeamState = arenaTeamState;
    }

    /**
     * Gibt den SpawnNamen wieder
     * @see de.byteevolve.gungame.location.Loc
     * @return SpawnName
     */
    public String getSpawn() {
        return spawn;
    }

    /**
     * Setzt den SpawnNamen
     * @see de.byteevolve.gungame.location.Loc
     * @param spawn neuer Spawnname
     */
    public void setSpawn(String spawn) {
        this.spawn = spawn;
    }

    /**
     * Gibt den MinSpawnNamen wieder
     * @see de.byteevolve.gungame.location.Loc
     * @return MinSpawnName
     */
    public String getMinSpawn() {
        return minSpawn;
    }

    /**
     * Setzt den MinSpawnNamem
     * @see de.byteevolve.gungame.location.Loc
     * @param minSpawn neuer MinSpawnname
     */
    public void setMinSpawn(String minSpawn) {
        this.minSpawn = minSpawn;
    }
    /**
     * Gibt den MaxSpawnNamen wieder
     * @see de.byteevolve.gungame.location.Loc
     * @return MaxSpawnName
     */
    public String getMaxSpawn() {
        return maxSpawn;
    }

    /**
     * Setzt den MaxSpawnNamem
     * @see de.byteevolve.gungame.location.Loc
     * @param maxSpawn neuer MaxSpawnname
     */
    public void setMaxSpawn(String maxSpawn) {
        this.maxSpawn = maxSpawn;
    }

    /**
     * Gibt den Anzeigenamen der Arena wieder
     * @return Anzeigename
     */
    public String getDisplayname() {
        return displayname.replaceAll("&", "§");
    }

    /**
     * Setzt den neuen Anzeigenamen der Arena
     * @param displayname neuer Anzeigename
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /**
     * Gibt den Absoluten Namen der Arena wieder
     * @return absoluter Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Absoluten Namen der Arena
     * @param name neuer absoluter Name
     */
    public void setName(String name) {
        this.name = name;
    }
}
