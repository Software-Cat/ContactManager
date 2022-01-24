package contacts.input;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Log4j2()
public class BirthDateAsker extends DateAsker {

    public BirthDateAsker() {
        super();
    }

    @Override
    public @Nullable LocalDate get() {
        try {
            return askForLocalDate("Enter the birth date");
        } catch (DateTimeParseException e) {
            logger.error("Bad birth date!");
            return null;
        }
    }
}
