package contacts.entry.field;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class AddressField extends StringField {

    public AddressField(@NotNull Supplier<String> valueSupplier, @Nullable String value) {
        super("address", "Address", valueSupplier, value);
    }

    public AddressField(@NotNull Supplier<String> valueSupplier) {
        this(valueSupplier, null);
    }

    public AddressField() {
        super("address", "Address");
    }
}
