package iafenvoy.cmdtip;

import iafenvoy.cmdtip.tip.TipManager;
import iafenvoy.cmdtip.util.FileUtil;
import iafenvoy.cmdtip.util.Language;
import net.fabricmc.api.ClientModInitializer;

public class CommandTip implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TipManager.INSTANCE.addTips(FileUtil.readResourceAsJson("/tips/minecraft.json", Language.Chinese));
    }
}
