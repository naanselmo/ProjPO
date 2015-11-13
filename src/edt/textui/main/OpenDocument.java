package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InvalidOperation;

/* FIXME: import core classes here */

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
     */
    public OpenDocument(Editor editor) {
        super(MenuEntry.OPEN, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        /* FIXME: implement command */
    }
}
