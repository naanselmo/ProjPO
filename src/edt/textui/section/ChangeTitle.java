package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Editor> {

    /**
     * Initializes the ChangeTitle command.
     *
     * @param editor The editor of the application.
     */
    public ChangeTitle(Editor editor) {
        super(MenuEntry.CHANGE_TITLE, editor);
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
