package edt.textui.section;

import edt.core.Paragraph;
import edt.core.Section;
import pt.utl.ist.po.ui.*;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Initializes the ChangeParagraph command.
     *
     * @param section The current section of being edited.
     */
    public ChangeParagraph(Section section) {
        super(MenuEntry.EDIT_PARAGRAPH, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        InputInteger localIdInput = new InputInteger(form, Message.requestParagraphId());
        InputString contentInput = new InputString(form, Message.requestParagraphContent());
        form.parse();

        int localId = localIdInput.value();
        if (entity().containsParagraph(localId)) {
            Paragraph paragraph = entity().getParagraph(localId);
            paragraph.setText(contentInput.value());
        } else {
            Display display = new Display();
            display.addNewLine(Message.noSuchParagraph(localId));
            display.display();
        }

    }
}
