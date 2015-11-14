package edt.textui.section;

import edt.core.Editor;
import pt.utl.ist.po.ui.Command;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Editor> {

    /**
     * Initializes the IndexParagraph command.
     *
     * @param editor The editor of the application.
     */
    public IndexParagraph(Editor editor) {
        super(MenuEntry.NAME_PARAGRAPH, editor);
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
