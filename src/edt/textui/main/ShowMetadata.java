package edt.textui.main;

import edt.core.Author;
import edt.core.Document;
import edt.core.Editor;
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
        Iterator<Author> authorIterator = document.getAuthors();
        Display display = new Display();

        display.addNewLine(Message.documentTitle(document.getTitle()));

        while (authorIterator.hasNext()) {
            Author author = authorIterator.next();
            display.addNewLine(Message.author(author.getName(), author.getEmail()));
        }

        display.addNewLine(Message.documentSections(document.getSectionsCount()));
        display.addNewLine(Message.documentBytes(document.getSize()));
        display.addNewLine(Message.documentIdentifiers(document.getTextElementsCount()));

        display.display();
    }
}
