package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import edt.textui.core.ComposedCommand;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends ComposedCommand<Document, Section> {

    /**
     * Initializes the SelectSection command.
     *
     * @param document The current document of the application.
     * @param section The current section being edited.
     */
    public SelectSection(Document document, Section section) {
        super(MenuEntry.SELECT_SECTION, document, section);
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
