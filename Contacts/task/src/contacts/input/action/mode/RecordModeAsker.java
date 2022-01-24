package contacts.input.action.mode;

import contacts.input.action.FieldAsker;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringJoiner;

public class RecordModeAsker extends FieldAsker {

    public RecordModeAsker() {
        super(List.of("edit", "delete", "menu"));
    }

    @Override
    public @NotNull String get() {
        StringJoiner sj = new StringJoiner(", ");
        for (String field : getValidFields()) {
            sj.add(field);
        }
        return askForFieldPersistent("[record] Enter action (" + sj + ")",
                "Please enter a valid action!");
    }

}
