package edt.textui.section;

import edt.core.Section;
import edt.core.Document;

import edt.textui.core.ComposedCommand;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputInteger;


/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends ComposedCommand<Document, Section> {

    /**
     * Initializes the SelectSection command.
     *
     * @param document The current document of the application.
     * @param section The current section being edited.
     */
    public SelectSection(Document document, Section section) {
        super(MenuEntry.SELECT_SECTION, document, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form form = new Form();
        Display display = new Display();
        InputInteger localId = new InputInteger(form, Message.requestSectionId());
        form.parse();

        if(!entity().containsSection(localId.value())){
             display.addNewLine(Message.noSuchSection(localId.value()));
            display.display();
        }else{
            display.addNewLine(Message.newActiveSection(localId.value()));
            Section section = entity().getSection(localId.value()); 
            display.display();
            new EditMenu(secondEntity(), section).open();
        }
    }
}
