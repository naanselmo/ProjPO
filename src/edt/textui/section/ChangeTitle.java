package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
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
