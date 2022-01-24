package contacts.action.mode;

import contacts.action.Command;
import contacts.action.Edit;
import contacts.action.Remove;
import contacts.base.Application;
import contacts.entry.Contact;
import contacts.input.action.mode.RecordModeAsker;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2()
public class RecordMode implements Mode {

    private final Contact contact;

    private final RecordModeAsker asker = new RecordModeAsker();

    public RecordMode(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void accept(@NotNull Application app) {
        String actionString = asker.get();
        switch (actionString) {
            case "edit" -> {
                Edit editCommand = (Edit) Command.EDIT.getAction();
                editCommand.edit(app, contact);
            }
            case "delete" -> {
                Remove removeCommand = (Remove) Command.REMOVE.getAction();
                removeCommand.remove(app, contact);
            }
            case "menu" -> app.getModeManager().setMode(app, new MenuMode());
        }
    }

    @Override
    public void onEnter(@NotNull Application app, @NotNull Mode lastMode) {
        System.out.println(contact.toString());
    }
}
