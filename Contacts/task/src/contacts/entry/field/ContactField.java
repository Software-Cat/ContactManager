package contacts.entry.field;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

@Data
@AllArgsConstructor
public abstract class ContactField<T> {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private Supplier<T> valueSupplier;

    @Nullable
    private T value;

    public ContactField(@NotNull String id, @NotNull String name, @NotNull Supplier<T> valueSupplier) {
        this.id = id;
        this.name = name;
        this.valueSupplier = valueSupplier;
    }

    public void updateValue() {
        value = valueSupplier.get();
    }

    @Override
    public String toString() {
        // The value.toString() method may produce NPE, but here the value == null
        // check prevents it from ever executing. The OR operator returns early if
        // value == null.
        if (value == null || value.toString().isBlank()) {
            return name + ": [no data]";
        }
        return name + ": " + value;
    }
}
