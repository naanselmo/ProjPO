package edt.textui.visitors;

import edt.core.Author;
import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.main.Message;

import java.util.Iterator;

/**
 * A metadata visitor. Responsible to gather metadata information of a document.
 */
public class MetadataVisitor extends ContentVisitor {

    public void visit(Document document) {
        _content.add(Message.documentTitle(document.getTitle()));
        Iterator<Author> iterator = document.getAuthors();
        while (iterator.hasNext())
            iterator.next().accept(this);
        _content.add(Message.documentSections(document.getSectionsCount()));
        _content.add(Message.documentBytes(document.getSize()));
        _content.add(Message.documentIdentifiers(document.getTextElementsCount()));
    }

    public void visit(Author author) {
        _content.add(Message.author(author.getName(), author.getEmail()));
    }

    public void visit(Section section) {
    }

    public void visit(Paragraph paragraph) {
    }

}