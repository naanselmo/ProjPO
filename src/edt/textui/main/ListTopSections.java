package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.core.Section;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.Iterator;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

    /**
     * Constructor of the ListTopSections command.
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
        display.addNewLine(document.getHeadline());
        Iterator<Section> iterator = document.getSections();
        while (iterator.hasNext()) {
            display.addNewLine(iterator.next().getHeadline());
        }
        display.display();
    }
}
