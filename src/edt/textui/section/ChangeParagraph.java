package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

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
        InputInteger localId = new InputInteger(form, Message.requestParagraphId());
        if(!entity().containsParagraph(localId.value())){
            form.parse();
            Display display = new Display();
            display.addNewLine(Message.noSuchParagraph(localId.value()));
            display.display();
        }
        else{
            InputString content = new InputString(form, Message.requestParagraphContent());
            form.parse();
            Paragraph paragraph = entity().getParagraph(localId.value());
            paragraph.setText(content.value());
        }

    }
}
