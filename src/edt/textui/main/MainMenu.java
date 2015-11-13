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
              new Command<?>[] { new NewDocument(document),
                      new OpenDocument(document),
                      new SaveDocument(document),
                      new ShowMetadata(document),
                      new AddAuthor(document),
                      new ListTopSections(document),
                      new ShowTextElement(document),
                      new EditSection(document),
                      });
    }
}
