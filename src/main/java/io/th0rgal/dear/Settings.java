package io.th0rgal.dear;

import org.json.simple.JSONObject;

public class Settings {

    private String token;
    private String prefix;
    private JSONObject embedTemplate;

    public Settings (String token, String prefix, JSONObject embedTemplate) {
        this.token = token;
        this.prefix = prefix;
        this.embedTemplate = embedTemplate;
    }

    public String getToken() {
        return this.token;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public JSONObject getEmbedTemplate() {
        return this.embedTemplate;
    }

}
