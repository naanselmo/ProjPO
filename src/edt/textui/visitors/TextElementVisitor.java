package edt.textui.visitors;

import edt.core.Author;
import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.main.Message;

import java.util.Iterator;

/**
 * A text element visitor. Responsible to gather information of a text element or document.
 */
public class TextElementVisitor extends ContentVisitor {

    public void visit(Document document) {
        _content.add("{" + document.getTitle() + "}");
        visitBody(document);
    }

    public void visit(Author author) {
    }

    public void visit(Section section) {
        if (section.hasId())
            _content.add(Message.sectionIndexEntry(section.getId(), section.getTitle()));
        else {
            _content.add(Message.sectionIndexEntry("", section.getTitle()));
        }
        visitBody(section);
    }

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

    public void visit(Paragraph paragraph) {
        _content.add(paragraph.getText());
    }

}