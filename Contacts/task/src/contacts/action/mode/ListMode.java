package contacts.action.mode;

import contacts.action.Command;
import contacts.base.Application;
import contacts.input.action.mode.ListModeAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class ListMode implements Mode {

    private final ListModeAsker asker = new ListModeAsker();

    public ListMode() {

    }

    @Override
    public void accept(@NotNull Application app) {
        String result = asker.get();

        if (ListModeAsker.isValidInteger(result, 10)) {
            int intResult = Integer.parseInt(result);
            // TODO: Remove possible index out of range here.
            app.getModeManager().setMode(app,
                    new RecordMode(app.getPhoneBook().get(intResult - 1)));
        } else if (ListModeAsker.isValidListCommand(result)) {
            switch (result) {
                case "back" -> app.getModeManager().setMode(app, new MenuMode());
//                case "again" -> performList(app);
            }
        }
    }

    public void performList(@NotNull Application app) {
        // Null check.
        if (app.getPhoneBook().size() == 0) {
            logger.warn("No records to list!");
            app.getModeManager().setMode(app, new MenuMode());
            return;
        }

        // Get the list action.
        Command.LIST.getAction().accept(app);
    }

    @Override
    public void onEnter(@NotNull Application app, @NotNull Mode lastMode) {
        performList(app);
    }
}
