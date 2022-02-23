package study;

@FunctionalInterface
public interface DelimiterSupplier<R> {
    R supply();
}
