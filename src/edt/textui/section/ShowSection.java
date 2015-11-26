package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;

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
        /* FIXME: implement command */
    }
}
