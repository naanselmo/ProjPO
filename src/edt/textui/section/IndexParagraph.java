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
public class IndexParagraph extends ComposedCommand<Document, Section> {

    /**
     * Initializes the IndexParagraph command.
     *
     * @param document The current document of the application.
     * @param section  The current section being edited.
     */
    public IndexParagraph(Document document, Section section) {
        super(MenuEntry.NAME_PARAGRAPH, document, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localId = new InputInteger(form, Message.requestParagraphId());
        InputString id = new InputString(form, Message.requestUniqueId());
        form.parse();

        Display display = new Display();
        int local = localId.value();
        if (entity().containsParagraph(local)) {
            Paragraph paragraph = entity().getParagraph(local);
            if (paragraph.hasId()) {
                display.addNewLine(Message.paragraphNameChanged());
            }
            entity().renameParagraph(secondEntity(), local, id.value());
        } else {
            display.addNewLine(Message.noSuchParagraph(local));
        }
        display.display();
    }
}
