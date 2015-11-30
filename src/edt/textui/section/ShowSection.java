package edt.textui.section;

import edt.core.Section;
import edt.textui.visitors.FormatterVisitor;
import edt.textui.visitors.TextElementVisitor;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Initializes the ShowSection command.
     *
     * @param section The current section being edited.
     */
    public ShowSection(Section section) {
        super(MenuEntry.SHOW_CONTENT, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        FormatterVisitor textElement = new TextElementVisitor();
        textElement.visit(entity());
        for (String string : textElement.getLines()) {
            display.addNewLine(string);
        }
        display.display();
    }
}
