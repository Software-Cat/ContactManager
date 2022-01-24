package contacts.entry;

import contacts.entry.field.ContactField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

@Log4j2()
public abstract class Contact {

    @Getter(AccessLevel.PROTECTED)
    private final List<ContactField<?>> fields;

    @Getter
    private final LocalDateTime timeCreated;

    @Getter
    @Setter
    private LocalDateTime timeLastEdit;

    public Contact(@NotNull List<ContactField<?>> fields) {
        this.fields = Collections.unmodifiableList(fields);

        LocalDateTime now = LocalDateTime.now();
        timeCreated = now;
        timeLastEdit = now;
    }

    /**
     * Calls the supplier on all fields to try to fill them with initial values.
     */
    public void initialize() {
        for (ContactField<?> field : fields) {
            field.updateValue();
        }
    }

    public @NotNull List<String> allFieldIds() {
        List<String> fieldIds = new ArrayList<>();
        for (ContactField<?> field : fields) {
            fieldIds.add(field.getId());
        }
        return fieldIds;
    }

    public @Nullable ContactField<?> getFieldById(@NotNull String id) {
        for (ContactField<?> field : fields) {
            if (field.getId().equals(id)) {
                return field;
            }
        }

        // Field not found.
        logger.error("Field '%s' not found!".formatted(id));
        return null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");

        for (ContactField<?> field : fields) {
            sj.add(field.toString());
        }

        sj.add("Time created: " + timeCreated.truncatedTo(ChronoUnit.DAYS));
        sj.add("Time last edit: " + timeLastEdit.truncatedTo(ChronoUnit.DAYS));

        return sj.toString();
    }

    public abstract @NotNull String getSimpleName();

    public @NotNull String getJoinedFields() {
        StringJoiner sj = new StringJoiner(" ");

        for (ContactField<?> field : fields) {
            if (field.getValue() != null) {
                sj.add(field.getValue().toString());
            }
        }

        return sj.toString();
    }
}
