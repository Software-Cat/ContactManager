package contacts.input;

import contacts.entry.field.StringField;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.Nullable;

@Log4j2()
public class StringAsker extends InputAsker<String> {

    private final StringField field;

    public StringAsker(StringField field) {
        super();
        this.field = field;
    }

    @Override
    public @Nullable String get() {
        String result = askForString("Enter the " + field.getId());

        if (result.isBlank()) {
            logger.error("Bad " + field.getId() + "!");
            return null;
        }

        return result;
    }
}
