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
                        new ChangeTitle(section),
                        new ListSections(section),
                        new ShowSection(section),
                        new SelectSection(section, document),
                        new InsertSection(section),
                        new IndexSection(section, document),
                        new RemoveSection(section, document),
                        new InsertParagraph(section),
                        new IndexParagraph(section, document),
                        new ChangeParagraph(section),
                        new RemoveParagraph(section, document)
                });
    }
}
