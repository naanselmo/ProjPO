package edt.core;

import java.io.Serializable;

/**
 * Paragraph class. Represents a paragraph.
 */
public class Paragraph extends TextElement implements Serializable {

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
     * Returns the paragraph's content.
     *
     * @return The content of this paragraph.
     */
    public String getContent() {
        return getText();
    }

    /**
     * Returns the paragraph's size.
     *
     * @return The size of this paragraph.
     */
    @Override
    public int getSize() {
        return getText().length(); //_text.getBytes().length;
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

}
