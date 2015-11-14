package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Editor> {

    /**
     * Initializes the IndexSection command.
     *
     * @param editor The editor of the application.
     */
    public IndexSection(Editor editor) {
        super(MenuEntry.NAME_SECTION, editor);
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
