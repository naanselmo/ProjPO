package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends ComposedCommand<Document, Section> {

    /**
     * Initializes the RemoveSection command.
     *
     * @param document The current document of the application.
     * @param section  The current section being edited.
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
        Form form = new Form();
        InputInteger localId = new InputInteger(form, Message.requestSectionId());
        form.parse();

        int local = localId.value();
        if (entity().containsSection(local)) {
            entity().removeSection(secondEntity(), local);
        }
    }
}
