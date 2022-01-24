package contacts.action;

import contacts.base.Application;
import contacts.entry.Contact;
import contacts.input.action.FieldAsker;
import contacts.input.action.IndexAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Log4j2()
public class Edit implements Action {

    private final IndexAsker indexAsker = new IndexAsker(1, 0);

    private final FieldAsker fieldAsker = new FieldAsker();

    public Edit() {

    }

    @Override
    public void accept(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to edit!");
            return;
        }

        // Display phonebook.
        Command.LIST.getAction().accept(app);

        // Ask for the index to edit.
        indexAsker.setMaxIndex(app.getPhoneBook().size() + 1);
        int index = indexAsker.get();
        Contact contact = app.getPhoneBook().get(index - 1);

        edit(app, contact);
    }

    public void edit(@NotNull Application app, @NotNull Contact contact) {
        // Ask for the field to edit.
        fieldAsker.setValidFields(contact.allFieldIds());
        String field = fieldAsker.get();

        // Edit the field.
        contact.getFieldById(field).updateValue();

        // Update the last edited time.
        contact.setTimeLastEdit(LocalDateTime.now());

        // Output the edited contact.
        logger.info("Saved.");
        System.out.println(contact);
    }
}
