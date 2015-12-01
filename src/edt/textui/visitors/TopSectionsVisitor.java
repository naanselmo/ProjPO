package edt.textui.visitors;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.visitors.formatter.ElementFormatter;
import edt.textui.visitors.formatter.FormatterVisitor;

import java.util.Iterator;

/**
 * A top sections visitor. Responsible to gather top sections information of a document.
 */
public class TopSectionsVisitor extends FormatterVisitor<ElementFormatter> {

    /**
     * Initializes a top sections visitor.
     *
     * @param formatter Formatter to use to format the content of this visitor.
     */
    public TopSectionsVisitor(ElementFormatter formatter) {
        super(formatter);
    }

    /**
     * Visits a document. Will add it's top sections to the content of this visitor.
     *
     * @param document Document to visit.
     */
    @Override
    public void visit(Document document) {
        _content.add(_formatter.formatDocument(document));
        Iterator<Section> iterator = document.getSections();
        while (iterator.hasNext()) {
            iterator.next().accept(this);
        }
    }

    /**
     * Visits a section. Will add it's format to the content of this visitor.
     *
     * @param section Section to visit.
     */
    @Override
    public void visit(Section section) {
        _content.add(_formatter.formatSection(section));
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

}
