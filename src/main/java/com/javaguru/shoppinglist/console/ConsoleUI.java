package com.javaguru.shoppinglist.console;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<MenuAction> actions;

    public ConsoleUI(List<MenuAction> actions) {
        this.actions = actions;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                for (int i = 0; i < actions.size(); i++){
                    System.out.println((i + 1) + ". " + actions.get(i).getMenuActionName());
                }
                int userInput = Integer.parseInt(scanner.nextLine()) - 1;
                if (userInput < 0 || userInput >= actions.size()){
                    throw new IllegalArgumentException("Incorrect input");
                }
                actions.get(userInput).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
