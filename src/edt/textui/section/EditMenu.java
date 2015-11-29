package edt.textui.section;

import edt.core.Document;
import edt.core.Section;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Represents the edit menu of this application. This menu
 * shows the option to edit the selected section.
 */
public class EditMenu extends Menu {

    /**
     * Initializes the edit menu of the application. It has all available options for editing
     * a section.
     *
     * @param document The current document of the application.
     * @param section  The current section being edited.
     */
    public EditMenu(Document document, Section section) {
        super(MenuEntry.TITLE,
                new Command<?>[]{
                        new IndexParagraph(document, section),
                        new IndexSection(document, section),
                        new RemoveParagraph(document, section),
                        new RemoveSection(document, section),
                        new SelectSection(document, section),
                        new ChangeTitle(section),
                        new ListSections(section),
                        new ShowSection(section),
                        new InsertSection(section),
                        new InsertParagraph(section),
                        new ChangeParagraph(section)
                });
    }
}
