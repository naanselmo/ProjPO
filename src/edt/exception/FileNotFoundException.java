package edt.exception;

import edt.textui.main.Message;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * An exception that tells that a file with a given path was not found.
 */
public class FileNotFoundException extends InvalidOperation {

    /**
     * Creates a new exception with a message defined withing {@link Message} class.
     *
     * @param filename Name of the file not found.
     */
    public FileNotFoundException(String filename) {
        super(Message.fileNotFound(filename));
    }

    /**
     * Creates a new exception with a message defined withing {@link Message} class.
     */
    public FileNotFoundException() {
        super(Message.fileNotFound());
    }

}
