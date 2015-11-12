package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/* FIXME: import core classes here */
import edt.core.*;

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

    public MainMenu(Document document) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new NewDocument(Document document),
                      new OpenDocument(Document document),
                      new SaveDocument(Document document),
                      new ShowMetadata(Document document),
                      new AddAuthor(Document document),
                      new ListTopSections(Document document),
                      new ShowTextElement(Document document),
                      new EditSection(Document document),
                      });
    }
}
