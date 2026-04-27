package me.dreggcake.eggBooks;

import co.aikar.commands.PaperCommandManager;
import me.dreggcake.eggBooks.Commands.BookCommand;
import me.dreggcake.eggBooks.Commands.EggBooksCommand;
import me.dreggcake.eggBooks.Config.Config;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class EggBooks extends SimplePlugin {

    private PaperCommandManager commandManager;

    @Override
    protected void onPluginStart() {
        Config.load();
        registerCommands();
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this);


        // optional: enable unstable api to use help
        commandManager.enableUnstableAPI("help");

        commandManager.getCommandCompletions().registerAsyncCompletion("books", c -> Config.getInstance().getAllBookNames());

        // 7: Register your commands - This first command demonstrates adding an exception handler to that command
        commandManager.registerCommand(new BookCommand());
        commandManager.registerCommand(new EggBooksCommand());

        // 9: Register default exception handler for any command that doesn't supply its own
        commandManager.setDefaultExceptionHandler((command, registeredCommand, sender, args, t) -> {
            getLogger().warning("Error occurred while executing command " + command.getName());
            return false; // mark as unhandeled, sender will see default message
        });

    }
}
