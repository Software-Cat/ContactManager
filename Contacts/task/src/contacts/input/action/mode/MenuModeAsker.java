package contacts.input.action.mode;

import contacts.input.action.FieldAsker;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringJoiner;

public class MenuModeAsker extends FieldAsker {

    public MenuModeAsker() {
        super(List.of("add", "list", "search", "count", "exit"));
    }

    @Override
    public @NotNull String get() {
        StringJoiner sj = new StringJoiner(", ");
        for (String field : getValidFields()) {
            sj.add(field);
        }
        return askForFieldPersistent("[menu] Enter action (" + sj + ")",
                "Please enter a valid action!");
    }
}
