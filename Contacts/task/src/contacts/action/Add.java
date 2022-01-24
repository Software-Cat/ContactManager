package contacts.action;

import contacts.base.Application;
import contacts.entry.Organization;
import contacts.entry.Person;
import contacts.input.action.AddAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class Add implements Action {

    private final AddAsker asker = new AddAsker();

    public Add() {

    }

    @Override
    public void accept(@NotNull Application app) {
        switch (asker.get()) {
            case PERSON -> {
                Person person = new Person();
                person.initialize();
                app.getPhoneBook().add(person);
            }
            case ORGANIZATION -> {
                Organization organization = new Organization();
                organization.initialize();
                app.getPhoneBook().add(organization);
            }
        }

        logger.info("The record added.");
    }
}
