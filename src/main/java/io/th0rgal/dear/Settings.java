package io.th0rgal.dear;

public class Settings {

    private String token;
    private String prefix;

    public Settings (String token, String prefix) {
        this.token = token;
        this.prefix = prefix;
    }

    public String getToken() {
        return this.token;
    }

    public String getPrefix() {
        return this.prefix;
    }

}
