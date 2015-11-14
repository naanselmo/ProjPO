package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Editor> {

    /**
     * Creates the NewDocument command.
     *
     * @param editor The editor of the application.
     */
    public NewDocument(Editor editor) {
        super(MenuEntry.NEW, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        entity().createDocument();
    }
}
