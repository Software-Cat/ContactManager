package contacts.entry.field;

import contacts.input.GenderAsker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class GenderField extends ContactField<Gender> {

    public GenderField(@NotNull Supplier<Gender> valueSupplier, @Nullable Gender value) {
        super("gender", "Gender", valueSupplier, value);
    }

    public GenderField(@NotNull String id, @NotNull String name, @NotNull Supplier<Gender> valueSupplier) {
        this(valueSupplier, null);
    }

    public GenderField() {
        super("gender", "Gender", new GenderAsker());
    }
}
