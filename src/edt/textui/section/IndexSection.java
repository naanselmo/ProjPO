package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for indexing ia subsection the current section .
 */
public class IndexSection extends ComposedCommand<Section, Document> {

    /**
     * Initializes the IndexSection command.
     *
     * @param section  The current section being edited.
     * @param document The current document of the application.
     */
    public IndexSection(Section section, Document document) {
        super(MenuEntry.NAME_SECTION, section, document);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localIdInput = new InputInteger(form, Message.requestSectionId());
        InputString uniqueIdInput = new InputString(form, Message.requestUniqueId());
        form.parse();

        int localId = localIdInput.value();
        Display display = new Display();
        if (entity().containsSection(localId)) {
            Section section = entity().getSection(localId);
            if (section.hasId()) {
                display.addNewLine(Message.sectionNameChanged());
            }
            entity().renameSection(secondEntity(), localId, uniqueIdInput.value());
        } else {
            display.addNewLine(Message.noSuchSection(localId));
        }
        display.display();
    }
}
