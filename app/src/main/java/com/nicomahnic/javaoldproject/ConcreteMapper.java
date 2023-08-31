package com.nicomahnic.javaoldproject;

import org.json.JSONObject;

public class ConcreteMapper implements JsonMapper<ConcreteData>{

    @Override
    public ConcreteData convert(JSONObject jsonObject) {
        return new ConcreteData(
                jsonObject.optString("field1"),
                jsonObject.optString("field2")
        );
    }
}
