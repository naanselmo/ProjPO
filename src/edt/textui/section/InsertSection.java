package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Editor> {

    /**
     * Initializes the InsertSection command.
     *
     * @param editor The editor of the application.
     */
    public InsertSection(Editor editor) {
        super(MenuEntry.INSERT_SECTION, editor);
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
