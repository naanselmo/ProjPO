package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;

/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends ComposedCommand<Document, Section> {

    /**
     * Initializes the IndexSection command.
     *
     * @param document The current document of the application.
     * @param section The current section being edited.
     */
    public IndexSection(Document document, Section section) {
        super(MenuEntry.NAME_SECTION, document, section);
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
