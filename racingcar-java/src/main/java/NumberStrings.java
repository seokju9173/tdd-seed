import java.util.List;

public class NumberStrings {
    private final String numberStrings;

    public NumberStrings(final String numberStrings) {
        this.numberStrings = numberStrings;
    }

    public List<String> split(final String regex) {
        return List.of(numberStrings.split(regex));
    }
}
