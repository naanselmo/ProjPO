package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
     */
    public InsertParagraph(Editor editor) {
        super(MenuEntry.INSERT_PARAGRAPH, editor);
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
