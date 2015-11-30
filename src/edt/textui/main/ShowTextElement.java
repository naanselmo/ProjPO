package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<Editor> {

    /**
     * Initializes the ShowTextElement command.
     *
     * @param editor The editor of the application.
     */
    public ShowTextElement(Editor editor) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputString id = new InputString(form, Message.requestElementId());
        form.parse();

        Document document = entity().getDocument();
        Display display = new Display();
        if (document.containsTextElement(id.value())) {
            display.add(document.getTextElement(id.value()).getContent());
        } else {
            display.add(Message.noSuchTextElement(id.value()));
        }
        display.display();
    }
}
