package com.parinder.dbtd.helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class DataFixtureHelper {

    @Step("Get the json document: {jsonResourcePath}")
    public static JsonObject getJsonDocument(String jsonResourcePath) {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(jsonResourcePath)).getFile());
            FileInputStream fileInputStream = new FileInputStream(file);
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(IOUtils.toString(fileInputStream, StandardCharsets.UTF_8));
            return jsonElement.getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonObject();
        }
    }
}
