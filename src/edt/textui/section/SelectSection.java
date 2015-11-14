package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Editor> {

    /**
     * Initializes the SelectSection command.
     *
     * @param editor The editor of the application.
     */
    public SelectSection(Editor editor) {
        super(MenuEntry.SELECT_SECTION, editor);
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
