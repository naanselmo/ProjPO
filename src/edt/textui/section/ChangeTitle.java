package edt.textui.section;

import edt.core.Section;

import edt.textui.section.Message;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Form;





/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Section> {

    /**
     * Initializes the ChangeTitle command.
     *
     * @param section The current section of being edited.
     */
    public ChangeTitle(Section section) {
        super(MenuEntry.CHANGE_TITLE, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputString title = new InputString(form, Message.requestSectionTitle());
        form.parse();

        entity().setTitle(title.value());
        //NOTE: After finish editor, change to visitor

    }
}
