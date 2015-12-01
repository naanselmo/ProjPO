package edt.textui.visitors;

import edt.core.*;
import edt.textui.main.Message;

import java.util.Iterator;

public class ListSectionsVisitor extends FormatterVisitor {

    @Override
    public void visit(Document document) {
        visit((Section) document);
    }

    @Override
    public void visit(Author author) {
    }

    @Override
    public void visit(TextElement element) {
    }

    @Override
    public void visit(Section section) {
        Iterator<Section> sectionIterator = section.getSections();
        while (sectionIterator.hasNext()) {
            Section subsection = sectionIterator.next();
            if (subsection.hasId()) {
                _content.add(Message.sectionIndexEntry(subsection.getId(), subsection.getTitle()));
            } else
                _content.add(Message.sectionIndexEntry("", subsection.getTitle()));
            subsection.accept(this);
        }
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

}