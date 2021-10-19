package com.javaguru.shoppinglist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(11)
public class ExitAction implements MenuAction {

    @Override
    public void execute() {
        System.out.println("Good Bye");
        System.exit(0);
    }

    @Override
    public String getMenuActionName() {
        return "Exit";
    }
}

