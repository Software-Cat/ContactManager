package contacts.entry.field;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class FirstNameField extends StringField {

    public FirstNameField(@NotNull Supplier<String> valueSupplier, @Nullable String value) {
        super("name", "Name", valueSupplier, value);
    }

    public FirstNameField(@NotNull Supplier<String> valueSupplier) {
        this(valueSupplier, null);
    }

    public FirstNameField() {
        super("name", "Name");
    }
}
