package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the editor.
     */
    public NewDocument(Editor editor) {
        super(MenuEntry.NEW, editor);
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
