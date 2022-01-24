package contacts.action;

import contacts.base.Application;
import contacts.entry.Contact;
import contacts.input.action.IndexAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class Info implements Action {

    private final IndexAsker asker = new IndexAsker(1, 0);

    public Info() {

    }

    @Override
    public void accept(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to display!");
            return;
        }

        // Display phonebook.
        Command.LIST.getAction().accept(app);

        // Ask for the index to display.
        asker.setMaxIndex(app.getPhoneBook().size() + 1);
        int index = asker.get();
        Contact contact = app.getPhoneBook().get(index - 1);

        // Display all fields.
        System.out.println(contact.toString());
    }
}
