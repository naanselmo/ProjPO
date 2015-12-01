package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;


/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
     * Initializes the InsertSection command.
     *
     * @param section The current section being edited.
     */
    public InsertSection(Section section) {
        super(MenuEntry.INSERT_SECTION, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localIdInput = new InputInteger(form, Message.requestSectionId());
        InputString titleInput = new InputString(form, Message.requestSectionTitle());
        form.parse();

        entity().addSection(new Section(titleInput.value()), localIdInput.value());
    }
}
