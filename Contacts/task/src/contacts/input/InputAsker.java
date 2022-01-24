package contacts.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;
import java.util.function.Supplier;

@Log4j2()
@AllArgsConstructor
public abstract class InputAsker<T> implements Supplier<T> {

    @NotNull
    private final Scanner scanner = new Scanner(System.in);

    @Getter
    @Setter
    @NotNull
    private String inputPrompt;

    public InputAsker() {
        this(": > ");
    }

    /**
     * Asks the user for a {@link String} response.
     *
     * @param query the query to prompt to the user.
     * @return the integer entered by the user.
     */
    public @NotNull String askForString(@NotNull String query) {
        System.out.print(query);
        printInputPrompt();
        return scanner.nextLine();
    }

    /**
     * Asks the user for an {@link Integer} response. Fails if the user input is not valid.
     *
     * @param query the query to prompt to the user
     * @return the integer entered by the user.
     * @throws NumberFormatException if the user input does not contain a parsable integer.
     */
    public int askForInt(@NotNull String query) throws NumberFormatException {
        return Integer.parseInt(askForString(query));
    }

    /**
     * Asks the user for an {@link Integer} response. Keeps asking until the user enters a valid input.
     *
     * @param query the query to prompt to the user
     * @return the integer entered by the user.
     */
    public int askForIntPersistent(@NotNull String query) {
        int result = 0;
        boolean succeeded = false;

        while (!succeeded) {
            try {
                result = askForInt(query);

                // This line won't be reached if the integer was not valid.
                succeeded = true;
            } catch (NumberFormatException e) {
                logger.error("Please enter a valid integer!");
            }
        }

        return result;
    }

    @Override
    public abstract @Nullable T get();

    private void printInputPrompt() {
        System.out.print(inputPrompt);
    }
}
