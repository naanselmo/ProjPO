package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends ComposedCommand<Document, Section> {

    /**
     * Initializes the IndexParagraph command.
     *
     * @param document The current document of the application.
     * @param section  The current section being edited.
     */
    public IndexParagraph(Document document, Section section) {
        super(MenuEntry.NAME_PARAGRAPH, document, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
