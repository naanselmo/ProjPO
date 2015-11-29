package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends ComposedCommand<Document, Section> {

    /**
     * Initializes the RemoveParagraph command.
     *
     * @param document The current document of the application.
     * @param section  The current section being edited.
     */
    public RemoveParagraph(Document document, Section section) {
        super(MenuEntry.REMOVE_PARAGRAPH, document, section);
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
