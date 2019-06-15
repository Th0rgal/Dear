package io.th0rgal.dear.utils;

import org.json.simple.JSONArray;

public class JSONUtils {

    public static String[] toStringArray(JSONArray jsonArray) {
        String[] stringArray = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++)
            stringArray[i] = (String) jsonArray.get(i);
        return stringArray;
    }

}
