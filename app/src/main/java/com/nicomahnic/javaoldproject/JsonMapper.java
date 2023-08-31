package com.nicomahnic.javaoldproject;

import org.json.JSONException;
import org.json.JSONObject;

public interface JsonMapper<T> {
    T convert(JSONObject jsonObject) throws JSONException;
}
