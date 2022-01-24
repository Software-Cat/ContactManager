package contacts.action.mode;

import contacts.action.Command;
import contacts.base.Application;
import contacts.input.action.mode.MenuModeAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class MenuMode implements Mode {

    private final MenuModeAsker asker = new MenuModeAsker();

    public MenuMode() {

    }

    @Override
    public void accept(@NotNull Application app) {
        String actionString = asker.get();
        switch (actionString) {
            case "add" -> Command.ADD.getAction().accept(app);
            case "count" -> Command.COUNT.getAction().accept(app);
            case "exit" -> Command.EXIT.getAction().accept(app);
            case "list" -> app.getModeManager().setMode(app, new ListMode());
            case "search" -> app.getModeManager().setMode(app, new SearchMode());
        }
    }
}
