package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.textui.visitors.ContentVisitor;
import edt.textui.visitors.TextElementVisitor;
import edt.textui.visitors.formatter.TextFormatter;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import java.util.Iterator;

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
        InputString elementIdInput = new InputString(form, Message.requestElementId());
        form.parse();

        Document document = entity().getDocument();
        String elementId = elementIdInput.value();
        Display display = new Display();
        if (document.containsTextElement(elementId)) {
            ContentVisitor visitor = new TextElementVisitor(new TextFormatter());
            document.getTextElement(elementId).accept(visitor);
            Iterator<String> lineIterator = visitor.getLines();
            while (lineIterator.hasNext())
                display.addNewLine(lineIterator.next());
        } else {
            display.add(Message.noSuchTextElement(elementId));
        }
        display.display();
    }
}
