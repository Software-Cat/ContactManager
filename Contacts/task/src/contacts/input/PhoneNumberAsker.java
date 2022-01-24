package contacts.input;

import contacts.entry.field.PhoneNumber;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Log4j2()
public class PhoneNumberAsker extends InputAsker<PhoneNumber> {

    public PhoneNumberAsker() {
        super();
    }

    @Override
    public @Nullable PhoneNumber get() {
        try {
            return askForPhoneNumber("Enter the number");
        } catch (IllegalArgumentException e) {
            logger.error("Bad number!");
            return null;
        }
    }

    public @Nullable PhoneNumber askForPhoneNumber(@NotNull String query) throws IllegalArgumentException {
        return new PhoneNumber(askForString(query));
    }
}
