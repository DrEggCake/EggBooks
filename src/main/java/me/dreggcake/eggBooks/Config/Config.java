package me.dreggcake.eggBooks.Config;

import me.dreggcake.eggBooks.Logic.BookData;
import org.mineacademy.fo.settings.YamlConfig;

import java.util.*;

public class Config extends YamlConfig {

    private static Config instance;

    private final Map<String, BookData> books = new HashMap<>();

    public static void load() {
        instance = new Config();
        instance.loadConfiguration("config.yml");
    }

    public static Config getInstance() {
        return instance;
    }

    public static void reloadConfig() {
        if (instance != null) instance.reload();
    }

    @Override
    protected void onLoad() {

        books.clear();

        if (!isSet("books"))
            return;

        for (String key : getMap("books").keySet()) {

            String path = "books." + key;

            String message = getString(path + ".message");
            String title = getString(path + ".title", "Book");
            String author = getString(path + ".author", "Server");

            List<List<String>> pages = new ArrayList<>();
            for (Object obj : getList(path + ".pages")) {
                pages.add((List<String>) obj);
            }

            BookData data = new BookData(message, title, author, pages);

            books.put(key.toLowerCase(), data);
        }
    }

    public BookData getBook(String name) {
        return books.get(name.toLowerCase());
    }

    public Set<String> getAllBookNames() {
        return books.keySet();
    }
}