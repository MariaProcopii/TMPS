package Decorator;

import model.User;

public class AdminUserDecorator extends UserDecorator {

    public AdminUserDecorator(User decoratedUser){
        super(decoratedUser);
    }
    @Override
    public boolean isAdmin() {
        return true;
    }

}
