package edt.textui.main;

import edt.core.Document;
import edt.core.Editor;
import edt.textui.visitors.FormatterVisitor;
import edt.textui.visitors.MetadataVisitor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

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
        FormatterVisitor visitor = new MetadataVisitor();
        document.accept(visitor);
        Display display = new Display();
        for (String line : visitor.getLines())
            display.addNewLine(line);
        display.display();
    }
}
