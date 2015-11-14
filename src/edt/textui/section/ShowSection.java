package edt.textui.section;

import pt.utl.ist.po.ui.Command;

import edt.core.Editor;
/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
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
