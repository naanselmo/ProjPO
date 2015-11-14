package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Editor> {

    /**
     * Initializes the RemoveSection command.
     *
     * @param editor The editor of the application.
     */
    public RemoveSection(Editor editor) {
        super(MenuEntry.REMOVE_SECTION, editor);
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
