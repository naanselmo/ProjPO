package edt.textui.visitors;

import edt.core.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A top sections visitor. Responsible to gather top sections information of a document.
 */
public class TopSectionsVisitor implements Visitor {

    private List<String> _content;

    public TopSectionsVisitor() {
        this._content = new LinkedList<>();
    }

    @Override
    public void visit(Document document) {
        _content.add(document.getHeadline());
        Iterator<Section> iterator = document.getSections();
        while (iterator.hasNext())
            iterator.next().accept(this);
    }

    @Override
    public void visit(Author author) {
    }

    @Override
    public void visit(TextElement element) {
    }

    @Override
    public void visit(Section section) {
        _content.add(section.getHeadline());
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

    public List<String> getLines() {
        return _content;
    }
}
