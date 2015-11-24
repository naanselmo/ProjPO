package edt.core;

public interface Visitor {
    void visit(Section section);

    void visit(Paragraph paragraph);

    void visit(Document document);

    void visit(TextElement element);

    void visit(Author author);
}
