package edt.textui.visitors;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.visitors.formatter.ElementFormatter;
import edt.textui.visitors.formatter.FormatterVisitor;

import java.util.Iterator;

/**
 * A text element visitor. Responsible to gather information of a text element or document.
 */
public class TextElementVisitor extends FormatterVisitor<ElementFormatter> {

    /**
     * Initializes a text element visitor.
     *
     * @param formatter Formatter to use to format the content of this visitor.
     */
    public TextElementVisitor(ElementFormatter formatter) {
        super(formatter);
    }

    /**
     * Visits a document. Will add it's format, all it's subsections and all it's paragraphs formatted
     * to the content of this visitor.
     *
     * @param document Document to visit.
     */
    public void visit(Document document) {
        _content.add(_formatter.formatDocument(document));
        visitBody(document);
    }

    /**
     * Visits a section. Will add it's format, all it's subsections and all it's paragraphs formatted
     * to the content of this visitor.
     *
     * @param section Section to visit.
     */
    public void visit(Section section) {
        _content.add(_formatter.formatSection(section));
        visitBody(section);
    }

    /**
     * Visits a section. Will add all it's subsections and all it's paragraphs formatted
     * to the content of this visitor.
     *
     * @param section Section to visit.
     */
    private void visitBody(Section section) {
        Iterator<Paragraph> paragraphIterator = section.getParagraphs();
        while (paragraphIterator.hasNext()) {
            paragraphIterator.next().accept(this);
        }
        Iterator<Section> sectionIterator = section.getSections();
        while (sectionIterator.hasNext()) {
            sectionIterator.next().accept(this);
        }
    }

    /**
     * Visits a paragraph. Will add it's format to the content of this visitor.
     *
     * @param paragraph Paragraph to visit.
     */
    public void visit(Paragraph paragraph) {
        _content.add(_formatter.formatParagraph(paragraph));
    }

}