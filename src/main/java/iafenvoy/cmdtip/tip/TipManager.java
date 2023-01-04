package iafenvoy.cmdtip.tip;

import iafenvoy.cmdtip.tip.registry.MinecraftCommand;

import java.util.HashMap;

public class TipManager {
    public static final TipManager INSTANCE = new TipManager();
    private final HashMap<String, TipProvider> providers = new HashMap<>();

    public TipManager() {
        MinecraftCommand.register(this);
    }

    public String getTip(String command) {
        if (command.isEmpty()) return "";
        String prefix = command.split(" ")[0];
        if (providers.containsKey(prefix))
            return providers.get(prefix).parse(command.split(" "));
        return "";
    }

    public boolean register(String prefix, TipProvider provider) {
        boolean override = providers.containsKey(prefix);
        providers.put(prefix, provider);
        return override;
    }
}
