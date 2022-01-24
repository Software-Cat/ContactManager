package contacts.action;

import contacts.base.Application;
import org.jetbrains.annotations.NotNull;

public class Exit implements Action {

    public Exit() {

    }

    @Override
    public void accept(@NotNull Application app) {
        app.setRunning(false);
    }
}
