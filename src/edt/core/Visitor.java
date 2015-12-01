package edt.core;

public interface Visitor {

    /**
     * Visits a document.
     *
     * @param document Document to visit.
     */
    void visit(Document document);

    /**
     * Visits a section.
     *
     * @param section Section to visit.
     */
    void visit(Section section);

    /**
     * Visits a paragraph.
     *
     * @param paragraph Paragraph to visit.
     */
    void visit(Paragraph paragraph);

}
