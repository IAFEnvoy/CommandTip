package iafenvoy.cmdtip.tip.registry;

import iafenvoy.cmdtip.tip.TipManager;
import net.minecraft.client.resource.language.I18n;

public class MinecraftCommand {
    public static void register(TipManager manager) {
        manager.register("advancement", cmd -> {
            if(cmd.length==1) return I18n.translate("cmdtip.advancement.text");
            if(cmd[1].equals("grant")) return I18n.translate("cmdtip.advancement.grant.text");
            if(cmd[1].equals("revoke")) return I18n.translate("cmdtip.advancement.revoke.text");
            return I18n.translate("cmdtip.advancement.text");
        });
        manager.register("attribute", cmd -> doNothing());
        manager.register("ban", cmd -> I18n.translate("cmdtip.ban.text"));
        manager.register("ban-ip", cmd -> I18n.translate("cmdtip.ban-ip.text"));
        manager.register("banlist", cmd -> {
            if(cmd.length==1) return I18n.translate("cmdtip.banlist.text");
            if(cmd[1].equals("players")) return I18n.translate("cmdtip.banlist.players.text");
            if(cmd[1].equals("ips")) return I18n.translate("cmdtip.banlist.ips.text");
            return I18n.translate("cmdtip.banlist.text");
        });
        manager.register("bossbar", cmd -> doNothing());
        manager.register("clear", cmd -> I18n.translate("cmdtip.clear.text"));
        manager.register("clone", cmd -> doNothing());
        manager.register("data", cmd -> doNothing());
        manager.register("datapack", cmd -> doNothing());
        manager.register("debug", cmd -> doNothing());
        manager.register("defaultgamemode", cmd -> doNothing());
        manager.register("deop", cmd -> doNothing());
        manager.register("difficulty", cmd -> doNothing());
        manager.register("effect", cmd -> doNothing());
        manager.register("enchant", cmd -> doNothing());
        manager.register("execute", cmd -> doNothing());
        manager.register("experience", cmd -> doNothing());
        manager.register("fill", cmd -> doNothing());
        manager.register("fillbiome", cmd -> doNothing());
        manager.register("forceload", cmd -> doNothing());
        manager.register("function", cmd -> doNothing());
        manager.register("gamemode", cmd -> doNothing());
        manager.register("gamerule", cmd -> doNothing());
        manager.register("give", cmd -> I18n.translate("cmdtip.give.text"));
        manager.register("help", cmd -> doNothing());
        manager.register("item", cmd -> doNothing());
        manager.register("jfr", cmd -> doNothing());
        manager.register("kick", cmd -> doNothing());
        manager.register("kill", cmd -> doNothing());
        manager.register("list", cmd -> doNothing());
        manager.register("locate", cmd -> doNothing());
        manager.register("loot", cmd -> doNothing());
        manager.register("me", cmd -> doNothing());
        manager.register("msg", cmd -> doNothing());
        manager.register("op", cmd -> doNothing());
        manager.register("pardon", cmd -> doNothing());
        manager.register("pardon-ip", cmd -> doNothing());
        manager.register("particle", cmd -> doNothing());
        manager.register("perf", cmd -> doNothing());
        manager.register("place", cmd -> doNothing());
        manager.register("playsound", cmd -> doNothing());
        manager.register("publish", cmd -> doNothing());
        manager.register("recipe", cmd -> doNothing());
        manager.register("reload", cmd -> doNothing());
        manager.register("save-all", cmd -> doNothing());
        manager.register("save-off", cmd -> doNothing());
        manager.register("save-on", cmd -> doNothing());
        manager.register("say", cmd -> doNothing());
        manager.register("schedule", cmd -> doNothing());
        manager.register("scoreboard", cmd -> doNothing());
        manager.register("seed", cmd -> doNothing());
        manager.register("setblock", cmd -> doNothing());
        manager.register("setidletimeout", cmd -> doNothing());
        manager.register("setworldspawn", cmd -> doNothing());
        manager.register("spectate", cmd -> doNothing());
        manager.register("spreadplayers", cmd -> doNothing());
        manager.register("stop", cmd -> doNothing());
        manager.register("stopsound", cmd -> doNothing());
        manager.register("summon", cmd -> I18n.translate("cmdtip.summon.text"));
        manager.register("tag", cmd -> doNothing());
        manager.register("team", cmd -> doNothing());
        manager.register("teammsg", cmd -> doNothing());
        manager.register("teleport", cmd -> doNothing());
        manager.register("tell", cmd -> doNothing());
        manager.register("tellraw", cmd -> doNothing());
        manager.register("time", cmd -> doNothing());
        manager.register("title", cmd -> doNothing());
        manager.register("tm", cmd -> doNothing());
        manager.register("tp", cmd -> doNothing());
        manager.register("trigger", cmd -> doNothing());
        manager.register("w", cmd -> doNothing());
        manager.register("weather", cmd -> doNothing());
        manager.register("whitelist", cmd -> doNothing());
        manager.register("worldborder", cmd -> doNothing());
        manager.register("xp", cmd -> doNothing());
    }

    public static String doNothing(){
        return "Do Nothing called";
    }
}
