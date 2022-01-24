package contacts.action;

import contacts.base.Application;
import contacts.entry.Contact;
import contacts.input.action.IndexAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class Remove implements Action {

    private final IndexAsker asker = new IndexAsker(1, 0);

    public Remove() {

    }

    @Override
    public void accept(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to remove!");
            return;
        }

        // Display phonebook.
        Command.LIST.getAction().accept(app);

        // Ask for the index to remove.
        asker.setMaxIndex(app.getPhoneBook().size() + 1);
        int index = asker.get();

        // Remove the entry.
        app.getPhoneBook().remove(index - 1);

        logger.info("The record removed.");
    }

    public void remove(@NotNull Application app, @NotNull Contact contact) {
        app.getPhoneBook().remove(contact);
        logger.info("The record removed.");
    }
}
