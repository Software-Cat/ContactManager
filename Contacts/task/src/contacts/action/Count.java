package contacts.action;

import contacts.base.Application;
import org.jetbrains.annotations.NotNull;

public class Count implements Action {

    public Count() {

    }

    @Override
    public void accept(@NotNull Application app) {
        System.out.printf("The Phone Book has %d records.", app.getPhoneBook().size());
        System.out.println();
    }
}
