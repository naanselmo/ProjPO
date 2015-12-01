package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;


/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends ComposedCommand<Section, Document> {

    /**
     * Initializes the SelectSection command.
     *
     * @param section  The current section being edited.
     * @param document The current document of the application.
     */
    public SelectSection(Section section, Document document) {
        super(MenuEntry.SELECT_SECTION, section, document);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localIdInput = new InputInteger(form, Message.requestSectionId());
        form.parse();

        int localId = localIdInput.value();
        Display display = new Display();
        if (entity().containsSection(localId)) {
            display.addNewLine(Message.newActiveSection(localId));
            display.display();
            new EditMenu(secondEntity(), entity().getSection(localId)).open();
        } else {
            display.addNewLine(Message.noSuchSection(localId));
            display.display();
        }
    }
}