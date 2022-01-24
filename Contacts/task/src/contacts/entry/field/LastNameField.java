package contacts.entry.field;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class LastNameField extends StringField {

    public LastNameField(@NotNull Supplier<String> valueSupplier, @Nullable String value) {
        super("surname", "Surname", valueSupplier, value);
    }

    public LastNameField(@NotNull Supplier<String> valueSupplier) {
        this(valueSupplier, null);
    }

    public LastNameField() {
        super("surname", "Surname");
    }
}
