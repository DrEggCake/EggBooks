package me.dreggcake.eggBooks.Logic;

import me.dreggcake.eggBooks.Config.Config;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private static final MiniMessage mm = MiniMessage.miniMessage();

    public static void openBook(Player player, String name) {

        BookData data = Config.getInstance().getBook(name);

        if (data == null) {
            player.sendMessage(Component.text("Book not found."));
            return;
        }

        // Send message
        if (data.getMessage() != null) {
            player.sendMessage(mm.deserialize(data.getMessage()));
        }

        // Build pages
        List<Component> pages = new ArrayList<>();

        for (List<String> pageLines : data.getPages()) {

            Component page = Component.empty();

            for (String line : pageLines) {
                page = page.append(mm.deserialize(line))
                        .append(Component.newline());
            }

            pages.add(page);
        }

        // Create book
        Book book = Book.book(
                mm.deserialize(data.getTitle()),
                mm.deserialize(data.getAuthor()),
                pages
        );

        // Open book
        player.openBook(book);
    }
}