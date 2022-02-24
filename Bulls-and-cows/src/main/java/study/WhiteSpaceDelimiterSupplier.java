package study;

public class WhiteSpaceDelimiterSupplier implements DelimiterSupplier<String>{
    @Override
    public String supply() {
        return " ";
    }
}
