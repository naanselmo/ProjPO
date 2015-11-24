package edt.textui;

import edt.textui.main.MainMenu;
import pt.utl.ist.po.ui.UserInteraction;

/**
 * The main class of the edt application.
 */
public class Editor {

    public static void main(String[] args) {
        edt.core.Editor editor = new edt.core.Editor();
        MainMenu menu = new MainMenu(editor);
        menu.open();
        UserInteraction.IO.close();
    }

}
