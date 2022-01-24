package contacts.entry.field;

import contacts.input.StringAsker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public abstract class StringField extends ContactField<String> {

    public StringField(@NotNull String id, @NotNull String name, @NotNull Supplier<String> valueSupplier, @Nullable String value) {
        super(id, name, valueSupplier, value);
    }

    public StringField(@NotNull String id, @NotNull String name, @NotNull Supplier<String> valueSupplier) {
        super(id, name, valueSupplier);
    }

    public StringField(@NotNull String id, @NotNull String name) {
        // Ignore this null warning, the next statement in line sets the value supplier,
        // so no way it can be null.
        super(id, name, () -> null);

        setValueSupplier(new StringAsker(this));
    }
}
