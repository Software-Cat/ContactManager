package contacts.input.action;

import contacts.input.InputAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2
public class SearchAsker extends InputAsker<String> {

    public SearchAsker() {
        super();
    }

    @Override
    public @NotNull String get() {
        return askForString("Enter search query");
    }
}
