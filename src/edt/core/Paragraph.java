package edt.core;

/**
 * Paragraph class. Represents a paragraph.
 */
public class Paragraph extends TextElement implements Element {

    private String _text;

    /**
     * Initializes a new Paragraph.
     *
     * @param text Paragraph's text.
     */
    public Paragraph(String text) {
        _text = text;
    }

    /**
     * Returns the paragraph's size.
     *
     * @return The size of this paragraph.
     */
    @Override
    public int getSize() {
        return getText().length();
    }

    /**
     * Returns the paragraph's text.
     *
     * @return The text of this paragraph.
     */
    public String getText() {
        return _text;
    }

    /**
     * Sets the paragraph's text.
     *
     * @param text The new text of this paragraph.
     */
    public void setText(String text) {
        _text = text;
    }

    /**
     * Accepts a visitor
     *
     * @param visitor Visitor to accept
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
