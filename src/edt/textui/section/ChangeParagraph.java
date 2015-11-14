package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Editor> {

    /**
     * Initializes the ChangeParagraph command.
     *
     * @param editor The editor of the application.
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
