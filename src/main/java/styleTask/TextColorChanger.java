package styleTask;

import enumClasses.ColorOptions;
import enumClasses.FormatOptions;
import model.Task;

public class TextColorChanger implements StyleTaskStrategy {
    public static int n = 0;
    public TextColorChanger() {
        n++;
    }

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
            case "black" -> ColorOptions.BLACK;
            case "red" -> ColorOptions.RED;
            case "green" -> ColorOptions.GREEN;
            case "yellow" -> ColorOptions.YELLOW;
            case "peach" -> ColorOptions.PEACH;
            case "magenta" -> ColorOptions.MAGENTA;
            case "cyan" -> ColorOptions.CYAN;
            case "white" -> ColorOptions.WHITE;
            default -> ColorOptions.RESET;
        };
    }
}
