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
        InputInteger localId = new InputInteger(form, Message.requestSectionId());
        InputString id = new InputString(form, Message.requestUniqueId());
        form.parse();

        Display display = new Display();
        int local = localId.value();
        if (entity().containsSection(local)) {
            Section section = entity().getSection(local);
            if (section.hasId()) {
                display.addNewLine(Message.sectionNameChanged());
            }
            entity().renameSection(secondEntity(), local, id.value());
        } else {
            display.addNewLine(Message.noSuchSection(local));
        }
        display.display();
    }
}
