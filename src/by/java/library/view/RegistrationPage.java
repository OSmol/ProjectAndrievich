package library.view;

import library.controller.command.Command;
import library.controller.command.impl.RegistrationCommand;

public class RegistrationPage implements Page {

    private Page mainPage = new MainPage();

    @Override
    public void run() {
        Command command = new RegistrationCommand();
    }
}
