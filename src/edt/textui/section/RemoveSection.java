package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends ComposedCommand<Section, Document> {

    /**
     * Initializes the RemoveSection command.
     *
     * @param section  The current section being edited.
     * @param document The current document of the application.
     */
    public RemoveSection(Section section, Document document) {
        super(MenuEntry.REMOVE_SECTION, section, document);
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
