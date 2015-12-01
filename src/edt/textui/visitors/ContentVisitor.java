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

    public ContentVisitor() {
        this._content = new LinkedList<>();
    }

    public Iterator<String> getLines() {
        return _content.iterator();
    }

}