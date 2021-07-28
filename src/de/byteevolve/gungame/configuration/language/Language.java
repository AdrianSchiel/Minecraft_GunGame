package de.byteevolve.gungame.configuration.language;

public interface Language {

    String getPath();
    String getDefaultMessage();
    String getMessage();
    void setMessage(String message);
}
