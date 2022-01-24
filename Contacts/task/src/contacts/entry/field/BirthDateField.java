package contacts.entry.field;

import contacts.input.BirthDateAsker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.function.Supplier;

public class BirthDateField extends ContactField<LocalDate> {

    public BirthDateField(@NotNull Supplier<LocalDate> valueSupplier, @Nullable LocalDate value) {
        super("birth", "Birth date", valueSupplier, value);
    }

    public BirthDateField(@NotNull Supplier<LocalDate> valueSupplier) {
        this(valueSupplier, null);
    }

    public BirthDateField() {
        super("birth", "Birth date", new BirthDateAsker());
    }
}
