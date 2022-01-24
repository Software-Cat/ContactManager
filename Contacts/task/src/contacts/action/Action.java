package contacts.action;

import contacts.base.Application;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@FunctionalInterface
public interface Action extends Consumer<Application> {

    @Override
    void accept(@NotNull Application app);
}
