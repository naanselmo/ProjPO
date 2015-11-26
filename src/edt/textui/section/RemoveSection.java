package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends ComposedCommand<Document, Section> {

    /**
     * Initializes the RemoveSection command.
     *
     * @param document The current document of the application.
     * @param section The current section being edited.
     */
    public RemoveSection(Document document, Section section) {
        super(MenuEntry.REMOVE_SECTION, document, section);
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
