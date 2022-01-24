package contacts.input.action;

import contacts.input.InputAsker;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

@Log4j2()
public class FieldAsker extends InputAsker<String> {

    @Getter
    @Setter
    @NotNull
    private List<String> validFields;

    public FieldAsker(@NotNull Collection<String> validFields) {
        super();
        this.validFields = new ArrayList<>(validFields);
    }

    public FieldAsker() {
        this(new ArrayList<>());
    }

    @Override
    public @NotNull String get() {
        StringJoiner sj = new StringJoiner(", ");
        for (String field : validFields) {
            sj.add(field);
        }
        return askForFieldPersistent("Select a field (" + sj + ")");
    }

    public @NotNull String askForField(@NotNull String query) throws IllegalArgumentException {
        String result = askForString(query);

        if (!validFields.contains(result)) {
            throw new IllegalArgumentException("Please enter a valid field!");
        }

        return result;
    }

    public @NotNull String askForFieldPersistent(@NotNull String query) {
        return askForFieldPersistent(query, "Please enter a valid field!");
    }

    protected @NotNull String askForFieldPersistent(@NotNull String query, @NotNull String errorText) {
        String result = null;
        boolean succeeded = false;

        while (!succeeded) {
            try {
                result = askForField(query);

                // This line won't be reached if the index was not valid.
                succeeded = true;
            } catch (IllegalArgumentException e) {
                logger.error(errorText);
            }
        }

        return result;
    }
}
