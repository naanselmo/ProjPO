package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
     */
    public ListTopSections(Editor editor) {
        super(MenuEntry.SHOW_INDEX, editor);
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
