package edt.textui.main;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import edt.core.Editor;
import edt.core.Document;
import edt.core.Section;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

    /**
     * Constructor.
     *
     * @param editor the target entity.
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
       Document doc = entity().getDocument();
       Iterator iterator= doc.getSections();
       Display display = new Display();
       display.addNewLine(doc.getHeadline());
       while(iterator.hasNext()){
            display.addNewLine(iterator.next().getHeadline());
       }

       display.display();

    }
}
