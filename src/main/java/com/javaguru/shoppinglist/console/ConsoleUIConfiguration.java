package com.javaguru.shoppinglist.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class ConsoleUIConfiguration {

    private final MenuAction createProductAction;
    private final MenuAction showAllProductsAction;
    private final MenuAction editProductAction;
    private final MenuAction findProductByIdAction;
    private final MenuAction removeProductAction;
    private final MenuAction exitAction;

    @Autowired
    ConsoleUIConfiguration(MenuAction createProductAction,
                                  MenuAction showAllProductsAction,
                                  MenuAction editProductAction,
                                  MenuAction findProductByIdAction,
                                  MenuAction removeProductAction,
                                  MenuAction exitAction) {
        this.createProductAction = createProductAction;
        this.showAllProductsAction = showAllProductsAction;
        this.editProductAction = editProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.removeProductAction = removeProductAction;
        this.exitAction = exitAction;
    }


    @Bean
    public ConsoleUI ui(){
        List<MenuAction> menuActions = new ArrayList<>();
        menuActions.add(createProductAction);
        menuActions.add(showAllProductsAction);
        menuActions.add(findProductByIdAction);
        menuActions.add(editProductAction);
        menuActions.add(removeProductAction);
        menuActions.add(exitAction);
        return new ConsoleUI(menuActions);
    }
}
