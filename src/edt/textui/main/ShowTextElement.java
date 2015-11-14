package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.core.TextElement;
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
        TextElement element = document.getTextElement(id.value());
        Display display = new Display();
        if (element != null) {
            display.add(element.getContent());
        } else {
            display.add(Message.noSuchTextElement(id.value()));
        }
        display.display();
    }
}
