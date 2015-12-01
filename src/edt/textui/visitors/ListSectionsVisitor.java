package edt.textui.visitors;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.visitors.formatter.ElementFormatter;
import edt.textui.visitors.formatter.FormatterVisitor;

import java.util.Iterator;

/**
 * A list sections visitor. Responsible to gather section information of a section or document.
 */
public class ListSectionsVisitor extends FormatterVisitor<ElementFormatter> {

    /**
     * Initializes a new list section visitor.
     *
     * @param formatter Formatter to use to format the content of this visitor.
     */
    public ListSectionsVisitor(ElementFormatter formatter) {
        super(formatter);
    }

    /**
     * Visits a document. Will add it's subsections to the content of this visitor.
     *
     * @param document Document to visit.
     */
    @Override
    public void visit(Document document) {
        visitSubsection(document);
    }

    /**
     * Visits a section. Will add it's subsections to the content of this visitor.
     * @param section Section to visit.
     */
    @Override
    public void visit(Section section) {
        visitSubsection(section);
    }

    /**
     * Will visit all of the subsections of the given section. Will format all subsections and add them to
     * the content of this visitor, accordingly to the formatter associated with this visitor.
     * @param section Section to visit.
     */
    private void visitSubsection(Section section) {
        Iterator<Section> sectionIterator = section.getSections();
        while (sectionIterator.hasNext()) {
            Section subsection = sectionIterator.next();
            _content.add(_formatter.formatSection(subsection));
            subsection.accept(this);
        }
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

}