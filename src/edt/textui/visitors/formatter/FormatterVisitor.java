package edt.textui.visitors.formatter;

import edt.textui.visitors.ContentVisitor;

/**
 * A visitor that has a formatter associated with it. May use the formatter to format it's content.
 *
 * @param <T> Type of the formatter. Needs to be a implementation of {@link Formatter}.
 */
public abstract class FormatterVisitor<T extends Formatter> extends ContentVisitor {

    protected T _formatter;

    /**
     * Initializes a new formatter visitor.
     *
     * @param formatter The formatter that this visitor may use to format it's content.
     */
    public FormatterVisitor(T formatter) {
        this._formatter = formatter;
    }

}
