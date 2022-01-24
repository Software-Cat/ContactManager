package contacts.input.action.mode;

import contacts.input.InputAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;

@Log4j2
public class ListModeAsker extends InputAsker<String> {

    public static boolean isValidListCommand(@NotNull String string) {
        return Objects.equals("back", string);
    }

    public static boolean isValidInteger(String string, int radix) {
        Scanner sc = new Scanner(string.trim());
        if (!sc.hasNextInt(radix)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(radix);
        return !sc.hasNext();
    }

    @Override
    public @NotNull String get() {
        return askForSearchCommandPersistent("[list] Enter action ([number], back)");
    }

    public @NotNull String askForSearchCommand(@NotNull String query) throws IllegalArgumentException {
        String result = askForString(query);

        if (!isValidListCommand(result) && !isValidInteger(result, 10)) {
            throw new IllegalArgumentException("Please enter a valid action!");
        }

        return result;
    }

    public @NotNull String askForSearchCommandPersistent(@NotNull String query) {
        String result = null;
        boolean succeeded = false;

        while (!succeeded) {
            try {
                result = askForSearchCommand(query);

                // This line won't be reached if the index was not valid.
                succeeded = true;
            } catch (IllegalArgumentException e) {
                logger.error("Please enter a valid action!");
            }
        }

        return result;
    }
}
