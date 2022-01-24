package contacts.input.action;

import contacts.action.Command;
import contacts.input.InputAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringJoiner;

@Log4j2()
public class CommandAsker extends InputAsker<Command> {

    @NotNull
    private final List<String> validFields = Command.allCommandIds();

    @Override
    public @NotNull Command get() {
        StringJoiner sj = new StringJoiner(", ");
        for (String field : validFields) {
            sj.add(field);
        }
        return askForCommandPersistent("Enter action (" + sj + ")");
    }

    public @NotNull Command askForCommand(@NotNull String query) throws IllegalArgumentException {
        String result = askForString(query);

        if (!validFields.contains(result)) {
            throw new IllegalArgumentException("Please enter a valid action!");
        }

        return Command.fromId(result);
    }

    public @NotNull Command askForCommandPersistent(@NotNull String query) {
        Command result = null;
        boolean succeeded = false;

        while (!succeeded) {
            try {
                result = askForCommand(query);

                // This line won't be reached if the index was not valid.
                succeeded = true;
            } catch (IllegalArgumentException e) {
                logger.error("Please enter a valid action!");
            }
        }

        return result;
    }
}
