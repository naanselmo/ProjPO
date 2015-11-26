package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;

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
        /* FIXME: implement command */
    }
}
