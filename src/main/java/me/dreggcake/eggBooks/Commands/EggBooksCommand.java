package me.dreggcake.eggBooks.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.dreggcake.eggBooks.Config.Config;
import me.dreggcake.eggBooks.Config.Lang;
import me.dreggcake.eggBooks.Settings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.settings.SimpleSettings;
import org.mineacademy.fo.settings.YamlStaticConfig;

@CommandAlias("eggbooks")
@CommandPermission("eggbooks.admin")
public class EggBooksCommand extends BaseCommand {

    @Default
    public void onDefault(CommandSender sender) {
        if (sender instanceof Player) {
            Common.tell(sender, Lang.getHelpMessage());
        } else {
            Common.log(Lang.getHelpMessage());
        }
    }

    @Subcommand("reload")
    public void onReload(CommandSender sender) {

        Config.reloadConfig();
        YamlStaticConfig.load(Lang.class);
        SimpleSettings.resetSettingsCall();
        SimpleSettings.load(Settings.class);

        if (sender instanceof Player) {
            Common.tell(sender, "Config reloaded successfully!");
        } else {
            Common.log("Config reloaded successfully!");
        }
    }

    @Subcommand("list")
    public void onList(CommandSender sender) {

        Config cfg = Config.getInstance();

        if (cfg.getAllBookNames().isEmpty()) {
            if (sender instanceof Player)
                Common.tell(sender, "&cNo books found.");
            else
                Common.log("&cNo books found.");
            return;
        }

        // Header
        if (sender instanceof Player)
            Common.tell(sender, "&6Available Books:");
        else
            Common.log("&6Available Books:");

        // Cclickable
        if (sender instanceof Player player) {

            for (String name : cfg.getAllBookNames()) {


                String mm = "<yellow>- " + name +
                        " <gray>[<green><click:run_command:'/books " + name +
                        "'>OPEN</click></green>]";
                player.sendMessage(net.kyori.adventure.text.minimessage.MiniMessage
                        .miniMessage()
                        .deserialize(mm));
            }

        } else {
            // no click for console
            for (String name : cfg.getAllBookNames()) {
                Common.log("&e- " + name);
            }
        }
    }

}
