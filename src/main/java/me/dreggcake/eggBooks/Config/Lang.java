package me.dreggcake.eggBooks.Config;

import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.List;

public class Lang extends YamlStaticConfig {
    private static List<String> helpMessage;

    @Override
    protected void onLoad() {
        this.loadConfiguration("lang.yml");
    }

    private static void init(){
        helpMessage = getStringList("help");
    }

    public static String getHelpMessage() {
        StringBuilder msg = new StringBuilder();
        for (String line : helpMessage) {
            msg.append(line).append("\n");
        }
        return msg.toString();
    }
}
