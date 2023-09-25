package Decorator;

import model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminInfoUserDecorator extends UserDecorator {
    private LocalDateTime promotionTime;

    public AdminInfoUserDecorator(User decoratedUser) {
        super(decoratedUser);
        this.promotionTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return super.toString() + additionalInfo();
    }

    public String additionalInfo(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = promotionTime.format(formatter);

        return ", Lon in time='" + formattedTime + '\'';

    }
}
