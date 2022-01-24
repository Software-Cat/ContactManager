package contacts.action;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@Log4j2()
public enum Command {
    ADD("add", new Add()),
    REMOVE("remove", new Remove()),
    EDIT("edit", new Edit()),
    COUNT("count", new Count()),
    LIST("list", new ListAction()),
    INFO("info", new Info()),
    SEARCH("search", new Search()),
    EXIT("exit", new Exit());

    @NotNull
    private final String id;

    @NotNull
    private final Action action;

    Command(@NotNull String id, @NotNull Action action) {
        this.id = id;
        this.action = action;
    }

    public static @NotNull List<String> allCommandIds() {
        List<String> commandIds = new ArrayList<>();
        for (Command command : Command.values()) {
            commandIds.add(command.id);
        }
        return commandIds;
    }

    public static @Nullable Command fromId(@NotNull String id) {
        for (Command command : Command.values()) {
            if (command.getId().equals(id)) {
                return command;
            }
        }

        // Command not found.
        logger.error("Command '%s' not found!".formatted(id));
        return null;
    }

    @Contract(pure = true)
    public @NotNull String getId() {
        return id;
    }

    @Contract(pure = true)
    public @NotNull Action getAction() {
        return action;
    }
}
