package edt.core;

public class Paragraph extends TextElement {

    private String _text;

    public Paragraph(String text) {
        _text = text;
    }

    public String getContent() {
        return _text;
    }

    @Override
    public int getSize() {
        return _text.getBytes().length;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }

}
