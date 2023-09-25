package Decorator;

import model.User;

public abstract class UserDecorator implements User {
    private User decoratedUser;

    public UserDecorator(User decoratedUser){
        this.decoratedUser = decoratedUser;
    }

    @Override
    public boolean isAdmin() {
        return decoratedUser.isAdmin();
    }

    @Override
    public String toString() {
        return decoratedUser.toString();
    }
}
