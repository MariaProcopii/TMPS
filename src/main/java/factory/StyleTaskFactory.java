package factory;

import styleTask.BackgroundColorChanger;
import styleTask.StyleTaskStrategy;
import styleTask.TextColorChanger;
import styleTask.TextFormatChanger;

public class StyleTaskFactory {
    public StyleTaskStrategy getStyleStrategy(String option){
        if(option == null || option.isEmpty()){
            return null;
        }
        return switch (option.toLowerCase()){
            case "text color" -> new TextColorChanger();
            case "background color" -> new BackgroundColorChanger();
            case "text format" -> new TextFormatChanger();
            default -> throw  new IllegalArgumentException("Unknown option " + option);
        };
    }
}
