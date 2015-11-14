package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Editor> {

    /**
     * Constructor of the OpenDocument command.
     *
     * @param editor The editor of the application.
     */
    public OpenDocument(Editor editor) {
        super(MenuEntry.OPEN, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        Form form = new Form();
        InputString path = new InputString(form, Message.openFile());
        form.parse();


        entity().loadDocument(path.value());
    }
}
