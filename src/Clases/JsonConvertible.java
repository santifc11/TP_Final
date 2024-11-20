package Clases;

import org.json.JSONObject;

public interface JsonConvertible {
    JSONObject toJson();
    void fromJson(JSONObject jsonObject);
}
