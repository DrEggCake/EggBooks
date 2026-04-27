# EggBooks

## Description

EggBooks is a lightweight Paper/Spigot plugin that lets you create and open custom in-game books using simple configuration.

It’s designed to make server guides, rules, menus, or interactive books easy to manage.

---

## Features

* Create unlimited custom books from a config file
* Fully customizable titles, authors, and pages
* Supports MiniMessage formatting
* Optional message sent before opening a book
* Simple command to open any book
* Clickable book list for quick access

---

## Requirements

* Minecraft version: 1.21+
* Server software: Paper (recommended) or Spigot
* Java version: 21+

---

## Installation

1. Build or download the plugin `.jar`
2. Place it into your `/plugins` folder
3. Start or restart your server
4. Edit the config files in `/plugins/EggBooks/`

---

## Commands

### /books

Opens a configured book

| Usage         | Description              | Permission |
| ------------- | ------------------------ | ---------- |
| /books <name> | Opens the specified book | (none)     |

---

### /eggbooks

Admin command

| Subcommand | Description                 | Permission     |
| ---------- | --------------------------- | -------------- |
| (none)     | Shows help message          | eggbooks.admin |
| reload     | Reloads configuration files | eggbooks.admin |
| list       | Lists all available books   | eggbooks.admin |

---

## Permissions

| Permission     | Description              | Default |
| -------------- | ------------------------ | ------- |
| eggbooks.admin | Access to admin commands | op      |

---

## Configuration

Books are defined in the config file.

Each book includes:

* Title
* Author
* Pages (multi-line, multiple pages supported)
* Optional message shown before opening

Formatting uses MiniMessage, so you can use colors, click events, etc.

---

## Example

```yaml
books:
  rules:
    title: "<gold>Server Rules"
    author: "<gray>Admin"
    message: "<yellow>Please read the rules!"
    pages:
      - - "<white>1. Be respectful"
        - "<white>2. No griefing"
      - - "<white>3. Have fun!"
```

---

## Build Instructions (for developers)

Recommended (runs tests + builds shaded JAR):

```bash
./gradlew build
```

Fast build (no tests):

```bash
./gradlew shadowJar
```

---

## Credits

This plugin uses:

* Foundation by MineAcademy
  https://github.com/kangarko/Foundation

* ACF
  https://github.com/aikar/commands
