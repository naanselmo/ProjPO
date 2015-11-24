package edt.core;

public interface Visitor {

    void visit(Document document);

    void visit(Author author);

    void visit(TextElement element);

    void visit(Section section);

    void visit(Paragraph paragraph);

}
