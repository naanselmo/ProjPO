package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Command;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Initializes the ListSections command.
     *
     * @param section The current section being edited.
     */
    public ListSections(Section section) {
        super(MenuEntry.LIST_SECTIONS, section);
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
