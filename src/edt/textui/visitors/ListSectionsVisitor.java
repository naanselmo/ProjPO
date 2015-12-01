package edt.textui.visitors;

import edt.core.Author;
import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.main.Message;

import java.util.Iterator;

/**
 * A list sections visitor. Responsible to gather section information of a section or document.
 */
public class ListSectionsVisitor extends ContentVisitor {

    @Override
    public void visit(Document document) {
        visitSubsection(document);
    }

    @Override
    public void visit(Author author) {
    }

    @Override
    public void visit(Section section) {
        visitSubsection(section);
    }

    private void visitSubsection(Section section) {
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