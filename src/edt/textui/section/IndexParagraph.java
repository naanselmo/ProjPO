package edt.textui.section;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.textui.core.ComposedCommand;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for indexing a paragraph of the current section.
 */
public class IndexParagraph extends ComposedCommand<Section, Document> {

    /**
     * Initializes the IndexParagraph command.
     *
     * @param section  The current section being edited.
     * @param document The current document of the application.
     */
    public IndexParagraph(Section section, Document document) {
        super(MenuEntry.NAME_PARAGRAPH, section, document);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localIdInput = new InputInteger(form, Message.requestParagraphId());
        InputString uniqueIdInput = new InputString(form, Message.requestUniqueId());
        form.parse();

        int localId = localIdInput.value();
        Display display = new Display();
        if (entity().containsParagraph(localId)) {
            Paragraph paragraph = entity().getParagraph(localId);
            if (paragraph.hasId()) {
                display.addNewLine(Message.paragraphNameChanged());
            }
            entity().renameParagraph(secondEntity(), localId, uniqueIdInput.value());
        } else {
            display.addNewLine(Message.noSuchParagraph(localId));
        }
        display.display();
    }
}
