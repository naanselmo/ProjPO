package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.textui.visitors.ContentVisitor;
import edt.textui.visitors.TopSectionsVisitor;
import edt.textui.visitors.formatter.TextFormatter;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.Iterator;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

    /**
     * Initializes the ListTopSections command.
     *
     * @param editor The editor of the application.
     */
    public ListTopSections(Editor editor) {
        super(MenuEntry.SHOW_INDEX, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Document document = entity().getDocument();
        ContentVisitor visitor = new TopSectionsVisitor(new TextFormatter());
        document.accept(visitor);
        Display display = new Display();
        Iterator<String> lineIterator = visitor.getLines();
        while (lineIterator.hasNext())
            display.addNewLine(lineIterator.next());
        display.display();
    }
}
