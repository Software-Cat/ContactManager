package contacts.input;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public abstract class DateAsker extends InputAsker<LocalDate> {

    public DateAsker() {
        super();
    }

    public @Nullable LocalDate askForLocalDate(@NotNull String query) throws DateTimeParseException {
        return LocalDate.parse(askForString(query));
    }
}
