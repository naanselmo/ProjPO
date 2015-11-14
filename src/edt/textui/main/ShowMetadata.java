package edt.textui.main;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.display;

/* FIXME: import core classes here */
import edt.core.Document;
import edt.core.Author;
import edt.core.Section;

import java.util.Iterator;
/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
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

        display.addNewLine(documentTitle(document.getTitle()));

        while(authorIterator.hasNext()){
            Author author = authorIterator.next();
            display.addNewLine(author(author.getTitle(),author.getTitle()));
        }

        display.addNewLine(documentSections(document.getSectionsCount()));
        display.addNewLine(documentBytes(document.getDocumentLength()));
        dispay.addNewLine(documentIdentifiers(document.getTextElementsCount()));

        display.display();
    }
}
