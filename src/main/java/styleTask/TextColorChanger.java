package styleTask;

import enumClasses.ColorOptions;
import model.Task;

public class TextColorChanger implements StyleTaskStrategy {

    @Override
    public void applyStyle(Task task, String arg) {
        ColorOptions colorCode = getColorCode(arg);
        task.setDescription(colorCode + task.getDescription() + "\u001B[0m");
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
