package Utiles;

import java.util.Map.Entry;
import org.bson.Document;
import org.json.JSONObject; //jsonLibm

public class JSONUtils {

    public static JSONObject Document2JSON(Document doc) {
        JSONObject r = new JSONObject();
        for (Entry<String, Object> e : doc.entrySet()) {
            r.put(e.getKey(), e.getValue());
        }
        return r;
    }

}
