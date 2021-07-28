package de.byteevolve.gungame.configuration.language;

import de.byteevolve.gungame.configuration.config.ConfigEntries;
import de.byteevolve.gungame.configuration.config.ConfigSections;
import de.byteevolve.gungame.configuration.language.languages.de_DE;
import de.byteevolve.gungame.configuration.language.languages.en_EN;
import org.apache.commons.lang3.EnumUtils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanguageHandler {

    List<String> languages;

    public LanguageHandler() {
        this.languages = new ArrayList<>();
        this.languages.add("de_DE");
        this.languages.add("en_EN");

        loadFiles();
        loadLanguage(ConfigEntries.LANGUAGE.getAsString());
    }

    public void loadLanguage(String lang){
        switch (lang){
            case "de_DE":
                for(Message message : Message.values()){
                    message.setMessage(de_DE.valueOf(message.toString()).getMessage());
                }
                break;
            case "en_EN":
                for(Message message : Message.values()){
                    message.setMessage(en_EN.valueOf(message.toString()).getMessage());
                }
                break;
        }
    }

    private void loadFiles() {
        for(String lang : this.languages){
            File file = new File("plugins/GunGame/languages/" + lang +".yml");
            if(!file.exists()){
                new File("plugins/GunGame/languages/").mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            YamlConfiguration configuration = new YamlConfiguration().loadConfiguration(file);
            configuration.options().copyDefaults(true);

            switch (lang){
                case "de_DE":
                    for(de_DE entry : de_DE.values()){
                        if(!configuration.contains(entry.getPath())){
                            configuration.set(entry.getPath(), entry.getDefaultMessage());
                        }else{
                            entry.setMessage(configuration.getString(entry.getPath()));
                        }
                    }

                    break;
                case "en_EN":
                    for(en_EN entry : en_EN.values()){
                        if(!configuration.contains(entry.getPath())){
                            configuration.set(entry.getPath(), entry.getDefaultMessage());
                        }else{
                            entry.setMessage(configuration.getString(entry.getPath()));
                        }
                    }
                    break;
            }
            try {
                configuration.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
