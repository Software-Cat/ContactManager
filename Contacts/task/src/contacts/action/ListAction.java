package contacts.action;

import contacts.base.Application;
import contacts.entry.Contact;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@Log4j2()
public class ListAction implements Action {

    public ListAction() {

    }

    @Override
    public void accept(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to list!");
        }

        printContacts(app, app.getPhoneBook());
    }

    public void printContacts(@NotNull Application app, @NotNull Collection<Contact> contacts) {
        int index = 1;
        for (Contact contact : contacts) {
            System.out.println(index + ". " + contact.getSimpleName());
            index++;
        }
    }
}
