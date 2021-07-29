package de.byteevolve.gungame.configuration.language.languages;

import de.byteevolve.gungame.configuration.language.Language;

public enum en_EN implements Language {
    PREFIX( "prefix", "&8[&aGun&2Game&8] ", "&8[&aGun&2Game&8] "),
    NOPERM( "noperm", "&7You are not allowed to use this command.", "&7You are not allowed to use this command."),
    MUSTAPLAYER( "mustaplayer", "&7You must be a &aplayer &7!", "&7You must be a &aplayer &7!"),
    PLAYERNOTONLINE( "playernotonline", "&7The specified player could not be found.", "&7The specified player could not be found."),

    //ARENA COMMAND
    PLAYERCREATESARENA( "playercreatesarena", "&cYou are already creating an Arena", "&cYou are already creating an Arena"),
    ARENAEXISTS( "arenaexists", "&7The arena:&a %ARENANAME% &7exists already.", "&7The arena:&a %ARENANAME% &7exists already."),
    PLAYERCREATEARENA( "playercreatearena", "&7You are now creating the arena:&a %ARENANAME%&7. (&2/arena edit&7)", "&7You are now creating the arena:&a %ARENANAME%&7. (&2/arena edit&7)"),
    ARENANOTEXISTS( "arenanotexists",  "&7The arena:&a %ARENANAME% &7does not exist.", "&7The arena:&a %ARENANAME% &7does not exist."),
    PLAYERNOTCREATESARENA( "playernotcreatesarena", "&7You are not creating an arena currently. (&2/arena create name&7)", "&7You are not creating an arena currently. (&2/arena create name&7)"),
    ARENAHELP( "arenahelp", "&7Use &c/arena &7<&ccreate&7,&cedit&7> &7<&cName&7> &7<&cDisplayname&7>", "&7Use &c/arena &7<&ccreate&7,&cedit&7> &7<&cName&7> &7<&cDisplayname&7>"),
    NOARENAEXISTS( "noarenaexists","&cNo arena has been created yet.", "&cNo arena has been created yet."),

    //BUILD COMMAND
    BUILDON( "buildon", "&7You are now in &aBuild mode&7.","&7You are now in &aBuild mode&7."),
    BUILDOFF( "buildoff", "&7You are &cno &7longer in &aBuild mode&7.","&7You are &cno &7longer in &aBuild mode&7."),

    //STATS COMMAND
    STATS( "stats", "&m&l&7-------- &aStats&7 -&a %PLAYER% &m&l&7-------- \n &7Kills:&a %KILLS% \n &7Deaths:&a %DEAHTS% \n &7Highscore:&a %HIGHSCORE% \n &7Points:&a %POINTS% \n &7KD:&a %KD% \n &7Rank:&a #%RANK% \n &7&m&l-------------------------------------",
            "&m&l&7-------- &aStats&7 -&a %PLAYER% &m&l&7-------- \n &7Kills:&a %KILLS% \n &7Deaths:&a %DEAHTS% \n &7Highscore:&a %HIGHSCORE% \n &7Points:&a %POINTS% \n &7KD:&a %KD% \n &7Rank:&a #%RANK% \n &7&m&l-------------------------------------"),

    //TEMAS COMMAND
    NOTEAMALLOWED( "noteamallowed", "&7You can't use this command on this &aMap &7.", "&7You can't use this command on this &aMap &7."),
    PLAYERINTEAM( "playerinteam", "&cThe player is already in a team", "&cThe player is already in a team"),
    PLAYERTEAMINVITE( "playerteaminvite", "&7You invited &a %TARGET% &7to a team.", "&7You invited&a %TARGET% &7to a team."),
    PLAYERCANTINVITETEAMMEMBER("playercantinviteteammember", "&cOnly the team owner can invite others.", "&cOnly the team owner can invite others."),
    TEAMCREATE( "teamcreate" , "&7You have created a &aTeam &7.", "&7You have created a &aTeam &7."),
    TEAMJOIN( "teamjoin", "&a%PLAYER% &7has joined the team.", "&a%PLAYER% &7has joined the team."),
    TEAMFULL( "teamisfull", "&cThe team is already full.", "&cThe team is already full."),
    TEAMJOINPLAYER( "teamjoinplayer", "&7You joined&a %OWNER% &2team&7.", "&7You joined&a %OWNER% &2team&7."),
    PLAYERHASNOTEAMINVITE("playerhasnoinvite", "&cYou have not been invited to any team.", "&cYou have not been invited to any team."),
    PLAYERISINTEAM( "playerisinteam", "&cYou are already in a team.", "&cYou are already in a team."),
    TARGETTEAMINVITE( "targetteaminvite", "&7You have been invited by&a %PLAYER% &7to join a &aTeam &7(&2/team accept&7).", "&7You have been invited by&a %PLAYER% &7to join a &aTeam &7(&2/team accept&7)."),
    TEAMINVITEHELP( "teaminvitehelp", "&cPlease use /team invite <player>", "&cPlease use /team invite <player>"),
    TEAMDENYOWNER( "teamdenyowner", "&a%PLAYER% &7has rejected your request.", "&a%PLAYER% &7has rejected your request."),
    TEAMDENYPLAYER( "teamdenyplayer", "&7You have rejected&a %OWNER% &crequest&7.", "&7You have rejected&a %OWNER% &crequest&7."),
    TEAMINFOOWNER( "teaminfoowner", "&cOwner&7:&a %OWNER%", "&cOwner&7:&a %OWNER%"),
    TEAMINFOMEMBER( "teaminfomember", "&7Member&7:&a %MEMBER%", "&7Member&7:&a %MEMBER%"),
    PLAYERNOTEAM( "playernoteam", "&cYou are not in any team!", "&cYou are not in any team!"),
    TEAMNEWOWNER( "teamnewowner", "&7You are now the &cOwner &7of the &aTeam&7.", "&7You are now the &cOwner &7of the &aTeam&7."),
    TEAMDELETE( "teamdelete", "&7You &cdissolved&7 your team.", "&7You &cdissolved&7 your team."),
    TEAMLEAVEMEMBER( "teamleavemember", "&a%PLAYER% &7has &cleft&7 the team.", "&a%PLAYER% &7has &cleft&7 the team."),
    TEAMLEAVEPLAYER( "teamleaveplayer", "&7You have &cleft &7the team from &a%OWNER%&7.", "&7You have &cleft &7the team from &a%OWNER%&7."),
    TEAMKICKPLAYER( "teamkickplayer", "&7You have been &removed&7from&a %OWNER% team.", "&7You have been &removed&7from&a %OWNER% team."),
    TEAMPLAYERNOTATTEAM( "teamplayernotatteam", "&cThe player %PLAYER% is not in your team.", "&cThe player %PLAYER% is not in your team."),
    TEAMNOPERMTOKICK( "teamnopermtokick", "&cYou do not have the permission to kick others from the team.", "&cYou do not have the permission to kick others from the team."),
    TEAMKICKHELP( "teamkickhelp", "&cPlease use /team kick <player>", "&cPlease use /team kick <player>"),
    TEAMHELP( "teamhelp", "&aTeam system information \n" +
            " &a/team invite &7<&aplayer&7> &7Invites a player to the team. \n" +
            " &a/team accept &7Accepts a request \n" +
            " &a/team deny &7Rejects a request \n" +
            " &a/team info &7Show all members of your team \n" +
            " &a/team leave &7Leaves the team \n" +
            " &a/team kick &7<&aplayer&7> Kicks a player from the team",
            "&aTeam system information \\n\" +\n" +
                    "            \" &a/team invite &7<&aplayer&7> &7Invites a player to the team. \\n\" +\n" +
                    "            \" &a/team accept &7Accepts a request \\n\" +\n" +
                    "            \" &a/team deny &7Rejects a request \\n\" +\n" +
                    "            \" &a/team info &7Show all members of your team \\n\" +\n" +
                    "            \" &a/team leave &7Leaves the team \\n\" +\n" +
                    "            \" &a/team kick &7<&aplayer&7> Kicks a player from the team"),
    //TEAMSTATES
    TEAMSTATEALLOWED( "allowed", "&aTeams allowed", "&aTeams allowed"),
    TEAMSTATEDISALLOWED( "disallowed", "&cTeams disallowed", "&cTeams disallowed"),

    //SCOREBOARD
    SCOREBOARD( "scoreboard", "&8&M&l------------&2\n&6✦ &8▎ &7Map\n &8➥ &7%MAP%&a\n&8  \n&c✪ &8▎ &7Record\n &8➥ &7%RECORD%&c\n&d\n&c❤ &8▎ &7Kills\n &8➥ &7%KILLS%\n&1\n&c✿ &8▎ &7Rank\n &8➥ &7#%RANK%\n&8&M&l------------&3",
            "&8&M&l------------&2\n&6✦ &8▎ &7Map\n &8➥ &7%MAP%&a\n&8  \n&c✪ &8▎ &7Record\n &8➥ &7%RECORD%&c\n&d\n&c❤ &8▎ &7Kills\n &8➥ &7%KILLS%\n&1\n&c✿ &8▎ &7Rank\n &8➥ &7#%RANK%\n&8&M&l------------&3"),
    SCOREBOARDNAME( "name","&aGun&2Game", "&aGun&2Game"),


    //DEATH
    PLAYERDEAD( "playerdead", "&7You died.", "&7You died."),
    PLAYERKILLED( "playerkilled", "&7You were killed by &c%KILLER%&7.", "&7You were killed by &c%KILLER%&7."),
    KILLERKILLS( "killerkills", "&7You killed&a %PLAYER% &7.", "&7You killed&a %PLAYER% &7."),

    //MAPCHANGE
    MAPCHANGE( "mapchange", "&7The map was set to&a %MAP% &7.", "&7The map was set to&a %MAP% &7."),
    MAPCHANGETIMER( "mapchangetimer", "&7The map changes in &a%SECONDS% seconds&7.", "&7The map changes in &a%SECONDS% seconds&7."),

    GAMEACTIONBARMAPCHANGE( "gameactionbarmapchange", "&7Mapchange in&8: &a%SECONDS%-seconds &8&l︳ &7%TEAMSTATE%.", "&7Mapchange in&8: &a%SECONDS%-seconds &8&l︳ &7%TEAMSTATE%."),
    GAMEACTIONBAR( "gameactionbar", "&7%TEAMSTATE%", "&7%TEAMSTATE%"),
    ;

    String path, message, defaultMessage, description;

    en_EN(String path, String message, String defaultMessage) {
        this.path = path;
        this.message = message;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
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
}
