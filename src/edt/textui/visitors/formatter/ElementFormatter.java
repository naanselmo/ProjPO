package edt.textui.visitors.formatter;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;

/**
 * Responsible to format a text element. Defines how element is formatted.
 */
public interface ElementFormatter extends Formatter {

    /**
     * Formats a document.
     *
     * @param document Document to format.
     * @return The formatted data of the given document.
     */
    String formatDocument(Document document);

    /**
     * Formats a section.
     *
     * @param section Section to format.
     * @return The formatted data of the given section.
     */
    String formatSection(Section section);

    /**
     * Formats a paragraph.
     *
     * @param paragraph Paragraph to format.
     * @return The formatted data of the given paragraph.
     */
    String formatParagraph(Paragraph paragraph);

}
