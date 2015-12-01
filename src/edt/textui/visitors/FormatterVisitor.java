package edt.textui.visitors;

/**
 * Created by André.
 */
public abstract class FormatterVisitor extends ContentVisitor {

    protected Formatter _formatter;

    public FormatterVisitor(Formatter formatter) {
        this._formatter = formatter;
    }

}
