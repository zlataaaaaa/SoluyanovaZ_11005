import org.json.JSONObject;

public class Archieve {
    private JSONObject jsonObject = new JSONObject();

    public void clear() {
        jsonObject = new JSONObject();
    } // Очистить JSONObject
    public JSONObject getJsonObject() {
        return jsonObject;
    } // Getter

    public void setJsonObject(JSONObject jsonObject) { // Setter
        this.jsonObject = jsonObject;
    }
}

