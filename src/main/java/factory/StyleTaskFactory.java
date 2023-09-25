package factory;

import styleTask.BackgroundColorChanger;
import styleTask.StyleTaskStrategy;
import styleTask.TextColorChanger;
import styleTask.TextFormatChanger;

import java.util.HashMap;


//FlyWeight design pattern
//Factory design pattern
public class StyleTaskFactory {
    StyleTaskStrategy styleTaskStrategy;
    HashMap<String, StyleTaskStrategy> strategies = new HashMap<>();
    public StyleTaskStrategy getStyleStrategy(String option){
        if(option == null || option.isEmpty()){
            return null;
        }

        styleTaskStrategy = strategies.get(option.toLowerCase().trim());
        if(styleTaskStrategy == null){
            switch (option.toLowerCase()){
                case "text color":
                    styleTaskStrategy = new TextColorChanger();
                    break;
                case "background color":
                    styleTaskStrategy = new BackgroundColorChanger();
                    break;
                case "text format":
                    styleTaskStrategy = new TextFormatChanger();
                    break;
                default: throw  new IllegalArgumentException("Unknown option " + option);
            }
        }

        strategies.put(option, styleTaskStrategy);
        return styleTaskStrategy;
    }
}
