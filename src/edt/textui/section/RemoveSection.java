package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
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
