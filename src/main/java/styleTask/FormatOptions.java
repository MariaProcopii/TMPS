package styleTask;

public enum FormatOptions {
    RESET("\u001B[0m"),
    BOLD("\u001B[1m"),
    ITALIC("\u001B[3m"),
    UNDERLINE("\u001B[4m");

    private final String code;

    FormatOptions(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
