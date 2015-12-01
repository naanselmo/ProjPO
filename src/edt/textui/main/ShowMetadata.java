package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.textui.visitors.ContentVisitor;
import edt.textui.visitors.MetadataVisitor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.Iterator;

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Editor> {

    /**
     * Initializes the ShowMetadata command.
     *
     * @param editor The editor of the application.
     */
    public ShowMetadata(Editor editor) {
        super(MenuEntry.SHOW_METADATA, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Document document = entity().getDocument();
        ContentVisitor visitor = new MetadataVisitor();
        document.accept(visitor);
        Display display = new Display();
        Iterator<String> lineIterator = visitor.getLines();
        while (lineIterator.hasNext())
            display.addNewLine(lineIterator.next());
        display.display();
    }
}
