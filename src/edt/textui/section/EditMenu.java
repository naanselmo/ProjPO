package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/* FIXME: import core classes here */

/**
 * Represents the edit menu of this application. This menu
 * shows the option to edit the selected section.
 ***/

public class EditMenu extends Menu {
    /**
     * Builds an EditMenu object. It has all available options for editing
     * a section.
     *
     * @param doc
     * @param section
     **/
    public EditMenu(Editor editor) {
        super(MenuEntry.TITLE,
                new Command<?>[]{new ChangeTitle(editor),
                        new ListSections(editor),
                        new ShowSection(editor),
                        new SelectSection(editor),
                        new InsertSection(editor),
                        new IndexSection(editor),
                        new RemoveSection(editor),
                        new InsertParagraph(editor),
                        new IndexParagraph(editor),
                        new ChangeParagraph(editor),
                        new RemoveParagraph(editor),
                });
    }
}
