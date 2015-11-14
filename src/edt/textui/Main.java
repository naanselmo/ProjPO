package edt.textui;

import edt.core.Editor;
import edt.textui.main.MainMenu;
import pt.utl.ist.po.ui.UserInteraction;

/**
 * The main class of the edt application.
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println(args.length);
        Editor editor = new Editor();
        MainMenu menu = new MainMenu(editor);
        menu.open();
        UserInteraction.IO.close();
    }

}
