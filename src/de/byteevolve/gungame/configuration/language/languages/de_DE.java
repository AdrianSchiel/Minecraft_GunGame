package de.byteevolve.gungame.configuration.language.languages;

import de.byteevolve.gungame.configuration.config.ConfigSections;
import de.byteevolve.gungame.configuration.language.Language;

public enum de_DE implements Language {
    PREFIX( "prefix", "&8[&aGun&2Game&8] ", "&8[&aGun&2Game&8] "),
    NOPERM( "noperm", "&7Du bist nicht berechtigt dieses Kommando zu verwenden.", "&7Du bist nicht berechtigt dieses Kommando zu verwenden."),
    MUSTAPLAYER( "mustaplayer", "&7Du musst ein &aSpieler &7sein!", "&7Du musst ein &aSpieler &7sein!"),
    PLAYERNOTONLINE( "playernotonline", "&7Der Angegebene Spieler konnte nicht gefunden werden.", "&7Der Angegebene Spieler konnte nicht gefunden werden."),

    //ARENA COMMAND
    PLAYERCREATESARENA( "playercreatesarena", "&cDu erstellst schon eine Arena", "&cDu erstellst schon eine Arena"),
    ARENAEXISTS( "arenaexists", "&7Die Arena:&a %ARENANAME% &7gibt es schon.", "&7Die Arena:&a %ARENANAME% &7gibt es schon."),
    PLAYERCREATEARENA( "playercreatearena", "&7Du erstellst nun die Arena:&a %ARENANAME%&7. (&2/arena edit&7)", "&7Du erstellst nun die Arena:&a %ARENANAME%&7. (&2/arena edit&7)"),
    ARENANOTEXISTS( "arenanotexists",  "&7Die Arena:&a %ARENANAME% &7gibt es nicht.", "&7Die Arena:&a %ARENANAME% &7gibt es nicht."),
    PLAYERNOTCREATESARENA( "playernotcreatesarena", "&7Du erstellst gerade keine Arena. (&2/arena create Name&7)", "&7Du erstellst gerade keine Arena. (&2/arena create Name&7)"),
    ARENAHELP( "arenahelp", "&7Nutze &c/arena &7<&ccreate&7,&cedit&7> &7<&cName&7> &7<&cDisplayname&7>", "&7Nutze &c/arena &7<&ccreate&7,&cedit&7> &7<&cName&7> &7<&cDisplayname&7>"),
    NOARENAEXISTS( "noarenaexists","&cEs wurde noch keine Arena erstellt.", "&cEs wurde noch keine Arena erstellt."),
    ARENADELETE("arenadelete", "&cDu hast die Arena &a%ARENA% &cgelöscht.", "&cDu hast die Arena &a%ARENA% &cgelöscht."),
    //BUILD COMMAND
    BUILDON( "buildon", "&7Du bist nun im &aBuild-Modus&7.","&7Du bist nun im &aBuild-Modus&7."),
    BUILDOFF( "buildoff", "&7Du bist nun &cnicht &7mehr im &aBuild-Modus&7.","&7Du bist nun &cnicht &7mehr im &aBuild-Modus&7."),

    //STATS COMMAND
    STATS( "stats", "&m&l&7-------- &aStats&7 -&a %PLAYER% &m&l&7-------- \n &7Kills:&a %KILLS% \n &7Tode:&a %DEAHTS% \n &7Rekord:&a %HIGHSCORE% \n &7Punkte:&a %POINTS% \n &7KD:&a %KD% \n &7Rang:&a #%RANK% \n &7&m&l-------------------------------------", "&m&l&7-------- &aStats&7 -&a %PLAYER% &m&l&7-------- \n &7Kills:&a %KILLS% \n &7Tode:&a %DEAHTS% \n &7Rekord:&a %HIGHSCORE% \n &7Punkte:&a %POINTS% \n &7KD:&a %KD% \n &7Rang:&a #%RANK% \n &7&m&l-------------------------------------"),

    //TEMAS COMMAND
    NOTEAMALLOWED( "noteamallowed", "&7Bei dieser &aMap &7kannst du diesen Command &cnicht &7benutzen.", "&7Bei dieser &aMap &7kannst du diesen Command &cnicht &7benutzen."),
    PLAYERINTEAM( "playerinteam", "&cDer Spieler ist schon in einem Team", "&cDer Spieler ist schon in einem Team"),
    PLAYERTEAMINVITE( "playerteaminvite", "&7Du hast&a %TARGET% &7zu einem Team eingeladen.", "&7Du hast&a %TARGET% &7zu einem Team eingeladen."),
    PLAYERCANTINVITETEAMMEMBER("playercantinviteteammember", "&cEs kann nur der Team-Inhaber andere einladen.", "&cEs kann nur der Team-Inhaber andere einladen."),
    TEAMCREATE( "teamcreate" , "&7Du hast ein &aTeam &7erstellt.", "&7Du hast ein &aTeam &7erstellt."),
    TEAMJOIN( "teamjoin", "&a%PLAYER% &7ist dem Team &2beigetreten&7.", "&a%PLAYER% &7ist dem Team &2beigetreten&7."),
    TEAMFULL( "teamisfull", "&cDas Team ist schon voll.", "&cDas Team ist schon voll."),
    TEAMJOINPLAYER( "teamjoinplayer", "&7Du bist dem Team von&a %OWNER% &2beigetreten&7.", "&7Du bist dem Team von&a %OWNER% &2beigetreten&7."),
    PLAYERHASNOTEAMINVITE("playerhasnoinvite", "&cDu wurdest zu keinem Team eingeladen.", "&cDu wurdest zu keinem Team eingeladen."),
    PLAYERISINTEAM( "playerisinteam", "&cDu bist schon in einem Team.", "&cDu bist schon in einem Team."),
    TARGETTEAMINVITE( "targetteaminvite", "&7Du wurdest von&a %PLAYER% &7zu einem &aTeam &7eingeladen(&2/team accept&7).", "&7Du wurdest von&a %PLAYER% &7zu einem &aTeam &7eingeladen."),
    TEAMINVITEHELP( "teaminvitehelp", "&cBitte nutze /team invite <Player>", "&cBitte nutze /team invite <Player>"),
    TEAMDENYOWNER( "teamdenyowner", "&a%PLAYER% &7hat deine Anfrage &cabgelehnt&7.", "&a%PLAYER% &7hat deine Anfrage &cabgelehnt&7."),
    TEAMDENYPLAYER( "teamdenyplayer", "&7Du hast die Anfrage von&a %OWNER% &cabgelehnt&7.", "&7Du hast die Anfrage von&a %OWNER% &cabgelehnt&7."),
    TEAMINFOOWNER( "teaminfoowner", "&cOwner&7:&a %OWNER%", "&cOwner&7:&a %OWNER%"),
    TEAMINFOMEMBER( "teaminfomember", "&7Member&7:&a %MEMBER%", "&7Member&7:&a %MEMBER%"),
    PLAYERNOTEAM( "playernoteam", "&cDu bist in keinem Team!", "&cDu bist in keinem Team!"),
    TEAMNEWOWNER( "teamnewowner", "&7Du bist nun der &cOwner &7des &aTeams&7.", "&7Du bist nun der &cOwner &7des &aTeams&7."),
    TEAMDELETE( "teamdelete", "&7Du hast dein Team &caufgelöst&7.", "&7Du hast dein Team &caufgelöst&7."),
    TEAMLEAVEMEMBER( "teamleavemember", "&a%PLAYER% &7hat das Team &cverlassen&7.", "&a%PLAYER% &7hat das Team &cverlassen&7."),
    TEAMLEAVEPLAYER( "teamleaveplayer", "&7Du hast das Team von&a %OWNER% &cverlassen&7.", "&7Du hast das Team von&a %OWNER% &cverlassen&7."),
    TEAMKICKPLAYER( "teamkickplayer", "&7Du wurdest aus dem Team von&a %OWNER% &centfernt&7.", "&7Du wurdest aus dem Team von&a %OWNER% &centfernt&7."),
    TEAMPLAYERNOTATTEAM( "teamplayernotatteam", "&cDer Spieler %PLAYER% ist nicht in deinem Team.", "&cDer Spieler %PLAYER% ist nicht in deinem Team."),
    TEAMNOPERMTOKICK( "teamnopermtokick", "&cDu hast nicht die Berechtigung andere aus dem Team zu kicken.", "&cDu hast nicht die Berechtigung andere aus dem Team zu kicken."),
    TEAMKICKHELP( "teamkickhelp", "&cBitte nutze /team kick <Player>", "&cBitte nutze /team kick <Player>"),
    TEAMHELP( "teamhelp", "&aInformationen zum Teamsystem \n &a/team invite &7<&aSpieler&7> &7Lädt einen Spieler in das Team ein \n &a/team accept &7Nimmt eine Anfrage an \n &a/team deny &7Lehnt eine Anfrage ab \n &a/team info &7Zeigt alle Mitglieder deines Teams an \n &a/team leave &7Verlässt das Team \n &a/team kick &7<&aSpieler&7> Kickt einen Spieler aus dem Team", "&aInformationen zum Teamsystem \n &a/team invite &7<&aSpieler&7> &7Lädt einen Spieler in das Team ein \n &a/team accept &7Nimmt eine Anfrage an \n &a/team deny &7Lehnt eine Anfrage ab \n &a/team info &7Zeigt alle Mitglieder deines Teams an \n &a/team leave &7Verlässt das Team \n &a/team kick &7<&aSpieler&7> Kickt einen Spieler aus dem Team"),

    //TEAMSTATES
    TEAMSTATEALLOWED( "allowed", "&aTeams erlaubt", "&aTeams erlaubt"),
    TEAMSTATEDISALLOWED( "disallowed", "&cTeams verboten", "&cTeams verboten"),

    //SCOREBOARD
    SCOREBOARD( "scoreboard", "&8&M&l------------&2\n&6✦ &8▎ &7Map\n &8➥ &7%MAP%&a\n&8  \n&c✪ &8▎ &7Rekord\n &8➥ &7%RECORD%&c\n&d\n&c❤ &8▎ &7Kills\n &8➥ &7%KILLS%\n&1\n&c✿ &8▎ &7Rang\n &8➥ &7#%RANK%\n&8&M&l------------&3",
            "&8&M&l------------&2\n&6✦ &8▎ &7Map\n &8➥ &7%MAP%&a\n&8  \n&c✪ &8▎ &7Rekord\n &8➥ &7%RECORD%&c\n&d\n&c❤ &8▎ &7Kills\n &8➥ &7%KILLS%\n&1\n&c✿ &8▎ &7Rang\n &8➥ &7#%RANK%\n&8&M&l------------&3"),
    SCOREBOARDNAME( "name","&aGun&2Game", "&aGun&2Game"),


    //DEATH
    PLAYERDEAD( "playerdead", "&7Du bist gestorben.", "&7Du bist gestorben."),
    PLAYERKILLED( "playerkilled", "&7Du wurdest von &c %KILLER% &7getötet.", "&7Du wurdest von &c %KILLER% &7getötet."),
    KILLERKILLS( "killerkills", "&7Du hast&a %PLAYER% &7getötet.", "&7Du hast&a %PLAYER% &7getötet."),

    //MAPCHANGE
    MAPCHANGE( "mapchange", "&7Die Map wurde auf&a %MAP% &7gesetzt.", "&7Die Map wurde auf&a %MAP% &7gesetzt."),
    MAPCHANGETIMER( "mapchangetimer", "&7Die Map wechselt in &a%SECONDS%-Sekunden&7.", "&7Die Map wechselt in &a%SECONDS%-Sekunden&7."),

    GAMEACTIONBARMAPCHANGE( "gameactionbarmapchange", "&7Mapchange in&8: &a%SECONDS%-Sekunden &8&l︳ &7%TEAMSTATE%", "&7Mapchange in&8: &a%SECONDS%-Sekunden &8&l︳ &7%TEAMSTATE%"),
    GAMEACTIONBAR( "gameactionbar", "&7%TEAMSTATE%", "&7%TEAMSTATE%"),


;
    String path, message, defaultMessage;

    de_DE(String path, String message, String defaultMessage) {
        this.path = path;
        this.message = message;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
