package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target ent.
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
