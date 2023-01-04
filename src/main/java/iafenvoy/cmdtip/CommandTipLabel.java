package iafenvoy.cmdtip;

import iafenvoy.cmdtip.tip.TipManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public class CommandTipLabel {
    private final int x, y, width, height;
    private final TextRenderer textRenderer;
    private String lastCmd = "", lastTip = "";

    public CommandTipLabel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textRenderer = MinecraftClient.getInstance().textRenderer;
    }

    public void render(MatrixStack matrices, String commandText) {
        if (!commandText.equals(this.lastCmd)) {
            this.lastTip = TipManager.INSTANCE.getTip(commandText);
            this.lastCmd = commandText;
        }
        if (this.lastTip.isEmpty()) return;
        DrawableHelper.fill(matrices, this.x, this.y, this.x + Math.min(this.width, this.textRenderer.getWidth(this.lastTip) + 4), this.y + this.height, -805306368);
        this.textRenderer.drawWithShadow(matrices, this.lastTip, this.x + 2, this.y + 2, -1);
    }
}
