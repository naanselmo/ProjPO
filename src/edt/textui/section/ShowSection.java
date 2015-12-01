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
        FormatterVisitor textElementVisitor = new TextElementVisitor();
        entity().accept(textElementVisitor);
        Display display = new Display();
        for (String string : textElementVisitor.getLines()) {
            display.addNewLine(string);
        }
        display.display();
    }
}
