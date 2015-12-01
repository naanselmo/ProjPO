package edt.textui.visitors.formatter;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.main.Message;

/**
 * A text formatter. Responsible to format all text elements in plain text.
 */
public class TextFormatter implements ElementFormatter {

    /**
     * Formats a document to plain text. Will just return the document's title inside curly brackets.
     *
     * @param document Document to format.
     * @return Document's title inside curly brackets
     */
    @Override
    public String formatDocument(Document document) {
        return "{" + document.getTitle() + "}";
    }

    /**
     * Formats a section to plain text. Will just return the section's identifier inside brackets followed by
     * the section's title inside curly brackets. If the section doesn't have an identifier, empty brackets will appear.
     *
     * @param section Section to format.
     * @return Section's identifier inside brackets followed by the section's title inside curly brackets.
     */
    @Override
    public String formatSection(Section section) {
        if (section.hasId())
            return Message.sectionIndexEntry(section.getId(), section.getTitle());
        return Message.sectionIndexEntry("", section.getTitle());
    }

    /**
     * Formats a paragraph to plain text. Will just return the paragraph's content.
     *
     * @param paragraph Paragraph to format.
     * @return Paragraph's content.
     */
    @Override
    public String formatParagraph(Paragraph paragraph) {
        return paragraph.getText();
    }

}