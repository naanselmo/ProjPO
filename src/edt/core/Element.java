package edt.core;

interface Element {
    void accept(Visitor visitor);
}
