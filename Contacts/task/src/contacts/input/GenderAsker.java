package contacts.input;

import contacts.entry.field.Gender;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Log4j2()
public class GenderAsker extends InputAsker<Gender> {

    public GenderAsker() {
        super();
    }

    @Override
    public @Nullable Gender get() {
        try {
            return askForGender("Enter the gender (M, F)");
        } catch (IllegalArgumentException e) {
            logger.error("Bad gender!");
            return null;
        }
    }

    public @Nullable Gender askForGender(@NotNull String query) throws IllegalArgumentException {
        switch (askForString(query)) {
            case "M" -> {
                return Gender.MALE;
            }
            case "F" -> {
                return Gender.FEMALE;
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
