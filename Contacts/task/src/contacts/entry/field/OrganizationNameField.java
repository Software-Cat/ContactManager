package contacts.entry.field;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class OrganizationNameField extends StringField {

    public OrganizationNameField(@NotNull Supplier<String> valueSupplier, @Nullable String value) {
        super("name", "Organization name", valueSupplier, value);
    }

    public OrganizationNameField(@NotNull Supplier<String> valueSupplier) {
        this(valueSupplier, null);
    }

    public OrganizationNameField() {
        super("name", "Organization name");
    }
}
