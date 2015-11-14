package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target ent.
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
