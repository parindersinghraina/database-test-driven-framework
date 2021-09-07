package com.parinder.dbtd.helper;

public class JsonHelper {

    public static String fixJsonFormat(String badJson) {
        // This is to fix to appropriately format the invalid json there is return by design.
        String betterJson = badJson.replaceAll("^\"+|\"+$", "");
        return betterJson.replace("\\", "");
    }
}
