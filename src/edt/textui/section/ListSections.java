package edt.textui.section;

import edt.core.Section;
import edt.textui.visitors.ContentVisitor;
import edt.textui.visitors.ListSectionsVisitor;
import edt.textui.visitors.formatter.TextFormatter;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.Iterator;


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
        ContentVisitor visitor = new ListSectionsVisitor(new TextFormatter());
        entity().accept(visitor);
        Display display = new Display();
        Iterator<String> lineIterator = visitor.getLines();
        while (lineIterator.hasNext())
            display.addNewLine(lineIterator.next());
        display.display();
    }
}
