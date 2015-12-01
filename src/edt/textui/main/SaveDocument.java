package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Editor> {

    /**
     * Initializes the SaveDocument command.
     *
     * @param editor The editor of the application.
     */
    public SaveDocument(Editor editor) {
        super(MenuEntry.SAVE, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        Document document = entity().getDocument();
        if (document.hasPath()) {
            entity().saveDocument();
        } else {
            Form form = new Form();
            InputString pathInput = new InputString(form, Message.newSaveAs());
            form.parse();

            entity().saveNewDocument(pathInput.value());
        }
    }
}
