package edt.textui.section;

import edt.core.Section;
import edt.textui.visitors.FormatterVisitor;
import edt.textui.visitors.ListSectionsVisitor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;


/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Initializes the ListSections command.
     *
     * @param section The current section being edited.
     */
    public ListSections(Section section) {
        super(MenuEntry.LIST_SECTIONS, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        FormatterVisitor listSectionsVisitor = new ListSectionsVisitor();
        entity().accept(listSectionsVisitor);
        Display display = new Display();
        for (String string : listSectionsVisitor.getLines()) {
            display.addNewLine(string);
        }
        display.display();
    }
}
