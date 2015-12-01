package edt.textui.main;

import edt.core.Author;
import edt.core.Document;
import edt.core.Editor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for adding a new author to the document in the editor.
 */
public class AddAuthor extends Command<Editor> {

    /**
     * Initializes the AddAuthor command.
     *
     * @param editor The editor of the application.
     */
    public AddAuthor(Editor editor) {
        super(MenuEntry.ADD_AUTHOR, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputString nameInput = new InputString(form, Message.requestAuthorName());
        InputString emailInput = new InputString(form, Message.requestEmail());
        form.parse();

        Document document = entity().getDocument();
        String name = nameInput.value();
        if (!document.addAuthor(new Author(name, emailInput.value()))) {
            Display display = new Display();
            display.add(Message.duplicateAuthor(name));
            display.display();
        }
    }
}
