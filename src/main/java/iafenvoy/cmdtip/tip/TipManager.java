package iafenvoy.cmdtip.tip;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class TipManager {
    public static final TipManager INSTANCE = new TipManager();
    private final List<JsonObject> tips = new ArrayList<>();

    public TipManager() {
    }

    public String getTip(String command) {
        if (command.equals("")) return "";
        String[] commands = command.split(" ");
        for (JsonObject tip : tips) {
            String res = getTipDfs(commands, 0, tip);
            if (res != null) return res;
        }
        return "";
    }

    private String getTipDfs(String[] commands, int index, JsonElement ele) {// *->any ?->default
        if (!ele.isJsonObject()) return ele.getAsString();
        JsonObject obj = ele.getAsJsonObject();
        if (index == commands.length) return obj.has("?") ? obj.get("?").getAsString() : null;
        String now = commands[index];
        if (obj.has(now))
            return getTipDfs(commands, index + 1, obj.get(now));
        if (obj.has("*"))
            return getTipDfs(commands, index + 1, obj.get("*"));
        if (obj.has("?")) return obj.get("?").getAsString();
        return null;
    }

    public void addTips(JsonObject object) {
        if (object != null)
            this.tips.add(object);
    }
}
