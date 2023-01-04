package iafenvoy.cmdtip.util;

public enum Language {
    Chinese("zh_cn"),
    English("en_us");

    private final String shortName;

    Language(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
