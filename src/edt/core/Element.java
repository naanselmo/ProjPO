package edt.core;

interface Element {

    /**
     * Accepts a visitor.
     *
     * @param visitor Visitor to accept.
     */
    void accept(Visitor visitor);

}
