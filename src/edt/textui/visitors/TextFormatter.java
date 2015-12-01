package edt.textui.visitors;

import edt.core.Author;
import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.main.Message;

/**
 * Created by André.
 */
public class TextFormatter implements Formatter {

    @Override
    public String format(Document document) {
        return "{" + document.getTitle() + "}";
    }

    @Override
    public String format(Author author) {
        return Message.author(author.getName(), author.getEmail());
    }

    @Override
    public String format(Section section) {
        if (section.hasId())
            return Message.sectionIndexEntry(section.getId(), section.getTitle());
        return Message.sectionIndexEntry("", section.getTitle());
    }

    @Override
    public String format(Paragraph paragraph) {
        return paragraph.getText();
    }

}
