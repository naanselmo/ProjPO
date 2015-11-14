package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Editor> {

    /**
     * Initializes the ListSections command.
     *
     * @param editor The editor of the application.
     */
    public ListSections(Editor editor) {
        super(MenuEntry.LIST_SECTIONS, editor);
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
