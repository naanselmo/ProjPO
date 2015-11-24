package edt.core;

public interface Element {
    void accept(Visitor visitor);
}
