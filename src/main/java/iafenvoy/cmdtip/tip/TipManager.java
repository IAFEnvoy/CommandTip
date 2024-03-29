package iafenvoy.cmdtip.tip;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import iafenvoy.cmdtip.util.Language;

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
            try {
                if (!tip.has(Language.CURRENT.getShortName())) continue;
                String res = getTipDfs(commands, 0, tip.get(Language.CURRENT.getShortName()), tip.get(Language.CURRENT.getShortName()).getAsJsonObject());
                if (res != null) return res;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private String getTipDfs(String[] commands, int index, JsonElement ele, JsonObject base) {// *->any ?->default |->link ~->local link
        if (!ele.isJsonObject()) return ele.getAsString();
        JsonObject obj = ele.getAsJsonObject();
        if (obj.has("|")) {
            String ret = getTipDfs(commands, 1, base.get(obj.get("|").getAsString()), base);
            if (ret != null) return ret;
        }
        if (index == commands.length) return obj.has("?") ? obj.get("?").getAsString() : null;
        String now = commands[index];
        if (obj.has(now)) {
            if (obj.get(now).isJsonObject() && obj.get(now).getAsJsonObject().has("~")) {
                now = obj.get(now).getAsJsonObject().get("~").getAsString();
                if (!obj.has(now)) return null;
            }
            String ret = getTipDfs(commands, index + 1, obj.get(now), base);
            if (ret != null) return ret;
        }
        if (obj.has("*")) {
            String ret = getTipDfs(commands, index + 1, obj.get("*"), base);
            if (ret != null) return ret;
        }
        if (obj.has("?")) return obj.get("?").getAsString();
        return null;
    }

    public void addTips(JsonObject object) {
        if (object != null)
            this.tips.add(object);
    }
}
