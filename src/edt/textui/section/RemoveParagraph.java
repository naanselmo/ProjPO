package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import edt.textui.core.ComposedCommand;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends ComposedCommand<Section, Document> {

    /**
     * Initializes the RemoveParagraph command.
     *
     * @param section  The current section being edited.
     * @param document The current document of the application.
     */
    public RemoveParagraph(Section section, Document document) {
        super(MenuEntry.REMOVE_PARAGRAPH, section, document);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localId = new InputInteger(form, Message.requestParagraphId());
        form.parse();

        int local = localId.value();
        if (entity().containsParagraph(local)) {
            entity().removeParagraph(secondEntity(), local);
        } else {
            Display display = new Display();
            display.addNewLine(Message.noSuchParagraph(local));
            display.display();
        }
    }
}
