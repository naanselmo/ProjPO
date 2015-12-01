package edt.textui.section;

import edt.core.Paragraph;
import edt.core.Section;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;


/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Initializes the InsertParagraph command.
     *
     * @param section The current section being edited.
     */
    public InsertParagraph(Section section) {
        super(MenuEntry.INSERT_PARAGRAPH, section);
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

        entity().addParagraph(new Paragraph(contentInput.value()), localIdInput.value());
    }
}
