package com.parinder.dbtd.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConversionHelper {

    public static void convertRecordToJsonObjectAndCreateJsonFile(ArrayList arrayList, String path) throws IOException {
        // CONVERT JAVA OBJECT TO JSON STRING
        Gson gson = new Gson();
        String jsonContent = gson.toJson(arrayList);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonContent);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), jsonObject);
    }
}
