package edt.textui.visitors;

import edt.core.Author;
import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;

/**
 * Defines how elements should be formatted.
 */
public interface Formatter {
    String format(Document document);

    String format(Author author);

    String format(Section section);

    String format(Paragraph paragraph);
}
