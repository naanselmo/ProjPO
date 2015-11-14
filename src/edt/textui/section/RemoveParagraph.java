package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
     */
    public RemoveParagraph(Editor editor) {
        super(MenuEntry.REMOVE_PARAGRAPH, editor);
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
