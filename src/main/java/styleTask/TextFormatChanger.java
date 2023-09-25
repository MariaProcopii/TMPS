package styleTask;

import enumClasses.FormatOptions;
import model.Task;

public class TextFormatChanger implements StyleTaskStrategy {
    @Override
    public void applyStyle(Task task, String arg) {
        FormatOptions colorCode = getColorCode(arg);
        String description = task.getDescription();
        if(description.charAt(1) == '['){
            description = task.getDescription().substring(3);
        }
        task.setDescription(colorCode + description + "\u001B[0m");
    }

    private FormatOptions getColorCode(String colorName) {
        return switch (colorName.toLowerCase()) {
            case "bold" -> FormatOptions.BOLD;
            case "italic" -> FormatOptions.ITALIC;
            case "underline" -> FormatOptions.UNDERLINE;
            default -> FormatOptions.RESET;
        };
    }
}
