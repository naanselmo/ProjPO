package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Initializes the InsertParagraph command.
     *
     * @param section The current section being edited.
     */
    public InsertParagraph(Section section) {
        super(MenuEntry.INSERT_PARAGRAPH, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
