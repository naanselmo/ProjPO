package edt.textui.section;

import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
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
