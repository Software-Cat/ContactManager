package contacts.entry;

import contacts.entry.field.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringJoiner;

public class Person extends Contact {

    public Person() {
        super(List.of(
                new FirstNameField(),
                new LastNameField(),
                new BirthDateField(),
                new GenderField(),
                new PhoneNumberField()
        ));
    }

    @Override
    public @NotNull String getSimpleName() {
        String firstName = null;
        String lastName = null;

        if (!(getFields().get(0).getValue() == null)) {
            firstName = (String) getFields().get(0).getValue();
        }
        if (!(getFields().get(1).getValue() == null)) {
            lastName = (String) getFields().get(1).getValue();
        }

        if (firstName == null && lastName == null) {
            return "[no data]";
        } else {
            StringJoiner sj = new StringJoiner(" ");
            sj.add(firstName);
            sj.add(lastName);
            return sj.toString();
        }
    }
}
