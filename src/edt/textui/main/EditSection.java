package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Editor> {

    /**
     * Constructor of the EditSection command.
     *
     * @param editor The editor of the application.
     */
    public EditSection(Editor editor) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

    }
}

