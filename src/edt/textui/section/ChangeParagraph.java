package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
     */
    public ChangeParagraph(Editor editor) {
        super(MenuEntry.EDIT_PARAGRAPH, editor);
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
