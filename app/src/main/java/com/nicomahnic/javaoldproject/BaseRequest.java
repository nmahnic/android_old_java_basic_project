package com.nicomahnic.javaoldproject;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseRequest<O> {
    private final JsonMapper<O> mapper;

    protected BaseRequest(JsonMapper<O> mapper) {
        this.mapper = mapper;
    }

    public O execute() {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://192.168.1.14:3000/data/");
            urlConnection = (HttpURLConnection) url.openConnection();
            int code = urlConnection.getResponseCode();
            Log.e("NM", String.valueOf(code));
            StringBuilder sb = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader( urlConnection.getInputStream() ));
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            return mapper.convert(new JSONObject(sb.toString()));
        } catch (Exception e) {
            Log.e("NM", e.getMessage());
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }
}
