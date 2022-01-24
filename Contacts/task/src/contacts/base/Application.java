package contacts.base;

import contacts.action.mode.ModeManager;
import lombok.Getter;
import lombok.Setter;

public class Application implements Runnable {

    @Getter
    private final PhoneBook phoneBook = new PhoneBook();

//    private final CommandAsker commandAsker = new CommandAsker();

    @Getter
    private final ModeManager modeManager = new ModeManager();

    @Setter
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
//            Command command = commandAsker.get();
//            command.getAction().accept(this);
            modeManager.accept(this);
            System.out.println();
        }
    }
}
