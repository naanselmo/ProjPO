package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Editor> {

    /**
     * Initializes the InsertParagraph command.
     *
     * @param editor The editor of the application.
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
