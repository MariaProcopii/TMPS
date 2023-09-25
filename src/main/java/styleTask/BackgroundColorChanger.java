package styleTask;

import enumClasses.ColorOptions;
import enumClasses.FormatOptions;
import model.Task;

public class BackgroundColorChanger implements StyleTaskStrategy{
    @Override
    public void applyStyle(Task task, String arg) {
        ColorOptions colorCode = getColorCode(arg);
        String description = task.getDescription();
        if(description.charAt(1) == '['){
            description = task.getDescription().substring(4);
        }
        task.setDescription(colorCode + description + "\u001B[0m");
    }


    private ColorOptions getColorCode(String colorName) {
        return switch (colorName.toLowerCase()) {
            case "black" -> ColorOptions.BG_BLACK;
            case "red" -> ColorOptions.BG_RED;
            case "green" -> ColorOptions.BG_GREEN;
            case "yellow" -> ColorOptions.BG_YELLOW;
            case "peach" -> ColorOptions.BG_PEACH;
            case "magenta" -> ColorOptions.BG_MAGENTA;
            case "cyan" -> ColorOptions.BG_CYAN;
            case "white" -> ColorOptions.BG_WHITE;
            default -> ColorOptions.RESET;
        };
    }
}
