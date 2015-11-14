package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Editor> {

    /**
     * Initializes the RemoveParagraph command.
     *
     * @param editor The editor of the application.
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
