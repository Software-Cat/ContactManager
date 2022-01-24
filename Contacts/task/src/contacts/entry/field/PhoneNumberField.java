package contacts.entry.field;

import contacts.input.PhoneNumberAsker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class PhoneNumberField extends ContactField<PhoneNumber> {

    public PhoneNumberField(@NotNull Supplier<PhoneNumber> valueSupplier, @Nullable PhoneNumber value) {
        super("number", "Number", valueSupplier, value);
    }

    public PhoneNumberField(@NotNull Supplier<PhoneNumber> valueSupplier) {
        this(valueSupplier, null);
    }

    public PhoneNumberField() {
        super("number", "Number", new PhoneNumberAsker());
    }
}
