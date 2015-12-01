package edt.textui.visitors;

import edt.core.*;
import edt.textui.main.Message;

import java.util.Iterator;

public class TextElementVisitor extends FormatterVisitor {

    public void visit(Document document) {
        _content.add("{" + document.getTitle() + "}");
        visitRecursive(document);
    }

    public void visit(Author author) {
    }

    public void visit(TextElement element) {
        element.accept(this);
    }

    public void visit(Section section) {
        if (section.hasId())
            _content.add(Message.sectionIndexEntry(section.getId(), section.getTitle()));
        else {
            _content.add(Message.sectionIndexEntry("", section.getTitle()));
        }
        visitRecursive(section);
    }

    private void visitRecursive(Section section) {
        Iterator<Paragraph> paragraphIterator = section.getParagraphs();
        while (paragraphIterator.hasNext()) {
            paragraphIterator.next().accept(this);
        }
        Iterator<Section> sectionIterator = section.getSections();
        while (sectionIterator.hasNext()) {
            Section subsection = sectionIterator.next();
            if (section.hasId())
                _content.add(Message.sectionIndexEntry(subsection.getId(), subsection.getTitle()));
            else {
                _content.add(Message.sectionIndexEntry("", subsection.getTitle()));
            }
            visitRecursive(subsection);
        }
    }

    public void visit(Paragraph paragraph) {
        _content.add(paragraph.getText());
    }

}