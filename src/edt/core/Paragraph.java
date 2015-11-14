package edt.core;

import java.io.Serializable;

public class Paragraph extends TextElement implements Serializable {

    private String _text;

    /**
     * Initializes a new Paragraph.
     * @param  text Paragraph's text.
     */
    public Paragraph(String text) {
        _text = text;
    }

    /**
     * Returns the paragraph's content.
     * @return The content.
     */
    public String getContent() {
        return _text;
    }

    /**
     * Returns the paragraph's size.
     * @return The size.
     */
    @Override
    public int getSize() {
        return _text.length(); //_text.getBytes().length;
    }

    /**
     * Returns the paragraph's text.
     * @return The text.
     */
    public String getText() {
        return _text;
    }

    /**
     * Sets the paragraph's text.
     * @param text The new text.
     */
    public void setText(String text) {
        _text = text;
    }

}
