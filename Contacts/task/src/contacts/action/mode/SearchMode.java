package contacts.action.mode;

import contacts.action.Command;
import contacts.action.Search;
import contacts.base.Application;
import contacts.entry.Contact;
import contacts.input.action.mode.SearchModeAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Log4j2()
public class SearchMode implements Mode {

    private final SearchModeAsker asker = new SearchModeAsker();

    private List<Contact> filteredContacts = new ArrayList<>();

    public SearchMode() {

    }

    @Override
    public void accept(@NotNull Application app) {
        String result = asker.get();

        if (SearchModeAsker.isValidInteger(result, 10)) {
            int intResult = Integer.parseInt(result);
            // TODO: Remove possible index out of range here.
            app.getModeManager().setMode(app,
                    new RecordMode(filteredContacts.get(intResult - 1)));
        } else if (SearchModeAsker.isValidSearchCommand(result)) {
            switch (result) {
                case "back" -> app.getModeManager().setMode(app, new MenuMode());
                case "again" -> performSearch(app);
            }
        }
    }

    public void performSearch(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to search!");
            app.getModeManager().setMode(app, new MenuMode());
            return;
        }

        // Get the search action.
        Search searchAction = (Search) Command.SEARCH.getAction();
        filteredContacts = searchAction.perform(app);
    }

    @Override
    public void onEnter(@NotNull Application app, @NotNull Mode lastMode) {
        performSearch(app);
    }
}
