package edt.textui.section;

import edt.core.Section;
import edt.textui.visitors.ContentVisitor;
import edt.textui.visitors.TextElementVisitor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.Iterator;

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Initializes the ShowSection command.
     *
     * @param section The current section being edited.
     */
    public ShowSection(Section section) {
        super(MenuEntry.SHOW_CONTENT, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        ContentVisitor visitor = new TextElementVisitor();
        entity().accept(visitor);
        Display display = new Display();
        Iterator<String> lineIterator = visitor.getLines();
        while (lineIterator.hasNext())
            display.addNewLine(lineIterator.next());
        display.display();
    }
}
