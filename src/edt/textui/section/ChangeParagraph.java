package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Initializes the ChangeParagraph command.
     *
     * @param section The current section of being edited.
     */
    public ChangeParagraph(Section section) {
        super(MenuEntry.EDIT_PARAGRAPH, section);
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
