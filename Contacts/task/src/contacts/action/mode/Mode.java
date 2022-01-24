package contacts.action.mode;

import contacts.base.Application;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface Mode extends Consumer<@NotNull Application> {

    @Override
    void accept(@NotNull Application app);

    /**
     * Called automatically by the state machine when the state is entered.
     *
     * @param app      the application
     * @param lastMode the mode that was switched from
     */
    default void onEnter(@NotNull Application app, @NotNull Mode lastMode) {
    }

    /**
     * Called automatically by the state machine when the state is exited.
     *
     * @param app     the application
     * @param newMode the mode that is switched to
     */
    default void onExit(@NotNull Application app, @NotNull Mode newMode) {
    }
}
