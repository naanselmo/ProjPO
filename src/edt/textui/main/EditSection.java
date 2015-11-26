package edt.textui.main;

import edt.core.Editor;
import edt.core.Document;
import edt.textui.section.EditMenu;
import pt.utl.ist.po.ui.Command;

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Editor> {

    /**
     * Initializes the EditSection command.
     *
     * @param editor The editor of the application.
     */
    public EditSection(Editor editor) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Document document = entity().getDocument();
        new EditMenu(document, document).open();
    }
}

