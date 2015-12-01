package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.textui.visitors.FormatterVisitor;
import edt.textui.visitors.TopSectionsVisitor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

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
        Display display = new Display();
        FormatterVisitor visitor = new TopSectionsVisitor();
        document.accept(visitor);
        for (String line : visitor.getLines())
            display.addNewLine(line);
        display.display();
    }
}
