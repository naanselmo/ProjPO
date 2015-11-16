package edt.core;

import edt.exception.FileNotFoundException;
import edt.parser.Parser;

import java.io.*;

/**
 * The editor class. Contains the current document and the create, save and load methods.
 */
public class Editor {

    /**
     * The current document of the editor.
     */
    private Document _document;

    /**
     * The checksum of the last saved state.
     */
    private String _lastChecksum;

    /**
     * Initializes a new Editor.
     * If the property import is not set, it will start with a {@link NullDocument} as the current document.
     */
    public Editor() {
        _document = new NullDocument();
        String propertyImport = System.getProperty("import");
        if (propertyImport != null) {
            Parser parser = new Parser();
            try {
                _document = parser.parse(propertyImport);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new anonymous document with an empty title in the Editor.
     */
    public void createDocument() {
        _document = new Document("");
    }

    /**
     * Saves the document to the file path of the {@link Document}.
     *
     * @throws FileNotFoundException If the file was not found.
     */
    public void saveDocument() throws FileNotFoundException {
        ObjectOutputStream out = null;
        String currentChecksum = getDocument().getChecksum();
        try {
            out = new ObjectOutputStream(new FileOutputStream(getDocument().getPath()));
            if (currentChecksum.equals(_lastChecksum)){
                out.writeObject(getDocument());
                _lastChecksum = currentChecksum;
            }
        } catch (java.io.FileNotFoundException e) {
            throw new FileNotFoundException(getDocument().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Links the path to the current {@link Document} and saves the Document to given path.
     *
     * @param path Path of the file to save the Document to.
     * @throws FileNotFoundException If the file was not found.
     */
    public void saveNewDocument(String path) throws FileNotFoundException {
        getDocument().setPath(path);
        saveDocument();
    }

    /**
     * Loads the {@link Document} that is withing the file given.
     *
     * @param path Path of the file to load the Document from.
     * @throws FileNotFoundException If the file was not found.
     */
    public void loadDocument(String path) throws FileNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(path));
            _document = (Document) in.readObject();
            _lastChecksum = getDocument().getChecksum();
        } catch (java.io.FileNotFoundException e) {
            throw new FileNotFoundException(getDocument().getPath());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets the current document of the editor.
     *
     * @return The current document of the editor.
     */
    public Document getDocument() {
        return _document;
    }

}
