package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
     */
    public AddAuthor(Editor editor) {
        super(MenuEntry.ADD_AUTHOR, editor);
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
