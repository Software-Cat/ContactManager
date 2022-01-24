package contacts.action;

import contacts.base.Application;
import contacts.entry.Contact;
import contacts.input.action.SearchAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

@Log4j2
public class Search implements Action {

    private final SearchAsker asker = new SearchAsker();

    public Search() {

    }

    @Override
    public void accept(@NotNull Application app) {
        perform(app);
    }

    public @NotNull List<Contact> perform(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to search!");
            return new ArrayList<>();
        }

        // Search for valid contacts.
        String regex = asker.get();
        List<Contact> results = search(app, regex);

        // Display results.
        printSearchResults(app, results);

        return results;
    }

    public @NotNull List<Contact> search(@NotNull Application app, @NotNull String regex) {
        // Get regex pattern.
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        // Search for results.
        List<Contact> results = new ArrayList<>();
        for (Contact contact : app.getPhoneBook()) {
            if (pattern.matcher(contact.getJoinedFields()).find()) {
                results.add(contact);
            }
        }

        return results;
    }

    public void printSearchResults(@NotNull Application app, @NotNull List<Contact> results) {
        if (results.size() != 1) {
            System.out.printf("Found %d results:%n", results.size());
        } else {
            System.out.println("Found 1 result:");
        }

        ListAction listAction = (ListAction) Command.LIST.getAction();
        listAction.printContacts(app, results);
    }
}
