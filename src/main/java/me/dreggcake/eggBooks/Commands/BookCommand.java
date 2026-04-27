package me.dreggcake.eggBooks.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import me.dreggcake.eggBooks.Logic.BookManager;
import org.bukkit.entity.Player;

@CommandAlias("books")
public class BookCommand extends BaseCommand {

    @Default
    @CommandCompletion("@books")
    public void onBooks(Player player, String name) {

        BookManager.openBook(player, name);
    }
}