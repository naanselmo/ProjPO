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
public class IndexSection extends ComposedCommand<Document, Section> {

    /**
     * Initializes the IndexSection command.
     *
     * @param document The current document of the application.
     * @param section  The current section being edited.
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
