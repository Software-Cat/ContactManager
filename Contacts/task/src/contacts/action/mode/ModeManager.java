package contacts.action.mode;

import contacts.base.Application;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@Log4j2()
public class ModeManager implements Consumer<@NotNull Application> {

    @NotNull
    private Mode mode;

    public ModeManager() {
        this(new MenuMode());
    }

    protected ModeManager(@NotNull Mode mode) {
        this.mode = mode;
    }

    @Override
    public void accept(@NotNull Application app) {
        mode.accept(app);
    }

    public void setMode(@NotNull Application app, @NotNull Mode newMode) {
        // Call onExit() on old mode
        Mode oldMode = this.mode;
        oldMode.onExit(app, newMode);

        // Switch modes.
        this.mode = newMode;

        // Call onEnter() on new mode.
        newMode.onEnter(app, oldMode);
    }
}
