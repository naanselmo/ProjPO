package edt.textui.visitors;

import edt.core.Visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A visitor that saves it's content.
 */
public abstract class ContentVisitor implements Visitor {

    protected List<String> _content;

    /**
     * Initializes a content visitor.
     */
    public ContentVisitor() {
        this._content = new LinkedList<>();
    }

    /**
     * Returns an iterator with the content of the visitor.
     *
     * @return Iterator with the content of this visitor.
     */
    public Iterator<String> getLines() {
        return _content.iterator();
    }

}