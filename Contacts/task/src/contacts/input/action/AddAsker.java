package contacts.input.action;

import contacts.input.InputAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class AddAsker extends InputAsker<AddAsker.ContactType> {

    public AddAsker() {
        super();
    }

    @Override
    public @NotNull AddAsker.ContactType get() {
        return askForContactTypePersistent("Enter the type (person, organization)");
    }

    public @NotNull ContactType askForContactType(@NotNull String query) throws IllegalArgumentException {
        switch (askForString(query)) {
            case "person" -> {
                return ContactType.PERSON;
            }
            case "organization" -> {
                return ContactType.ORGANIZATION;
            }
            default -> throw new IllegalArgumentException("Please enter a valid contact type!");
        }
    }

    public @NotNull ContactType askForContactTypePersistent(@NotNull String query) {
        ContactType result = null;
        boolean succeeded = false;

        while (!succeeded) {
            try {
                result = askForContactType(query);

                // This line won't be reached if the contact type was not valid.
                succeeded = true;
            } catch (IllegalArgumentException e) {
                logger.error("Please enter a valid contact type!");
            }
        }

        return result;
    }

    public enum ContactType {
        PERSON,
        ORGANIZATION
    }
}
