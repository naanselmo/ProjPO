package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Editor> {

    /**
     * Initializes the ShowSection command.
     *
     * @param editor The editor of the application.
     */
    public ShowSection(Editor editor) {
        super(MenuEntry.SHOW_CONTENT, editor);
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
