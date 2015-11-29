package edt.textui.visitors;

import edt.core.Visitor;

import java.util.LinkedList;
import java.util.List;

public abstract class FormatterVisitor implements Visitor {

    protected List<String> _content;

    public FormatterVisitor() {
        this._content = new LinkedList<>();
    }

    public List<String> getLines() {
        return _content;
    }

}