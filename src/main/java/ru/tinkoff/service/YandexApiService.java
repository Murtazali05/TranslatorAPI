package ru.tinkoff.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class YandexApiService {
    private static final String HOST = "https://translate.yandex.net";
    private static final String PATH = "/api/v1.5/tr.json/translate";
    private static final String API_KEY = "trnsl.1.1.20190120T154928Z.5bb2548c85570527.57dcebba122fd8a5a7c10b961decb850a278b1c2";

    public String translateWord(String word, String from, String to) throws IOException, ParseException {
        String lang = from + "-" + to;
        String requestUrl = HOST + PATH + "?key=" + API_KEY + "&lang=" + lang + "&text=" + word;

        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return getTranslateFromJSON(response.toString());
    }

    private String getTranslateFromJSON(String str) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(str);
        StringBuilder sb = new StringBuilder();
        JSONArray array = (JSONArray) object.get("text");
        for (Object s : array) {
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
