package styleTask;

import org.example.Task;

public class TextFormatChanger implements StyleTaskStrategy {
    @Override
    public void applyStyle(Task task, String arg) {
        FormatOptions colorCode = getColorCode(arg);
        task.setDescription(colorCode + task.getDescription() + "\u001B[0m");
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
