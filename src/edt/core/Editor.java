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
     * Initializes a new Editor.
     * If the property import is not set, it will start with a {@link NullDocument} as the current document.
     */
    public Editor() {
        this._document = new NullDocument();
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
        /* FIXME: IF NO CHANGES WERE DONE DON'T DO SHIT! */
        try {
            FileOutputStream file = new FileOutputStream(_document.getPath());
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(_document);
            out.close();
            file.close();
        } catch (IOException e) {
            throw new FileNotFoundException(_document.getPath());
        }
    }

    /**
     * Links the path to the current {@link Document} and saves the Document to given path.
     *
     * @param path Path of the file to save the Document to.
     * @throws FileNotFoundException If the file was not found.
     */
    public void saveNewDocument(String path) throws FileNotFoundException {
        _document.setPath(path);
        saveDocument();
    }

    /**
     * Loads the {@link Document} that is withing the file given.
     *
     * @param path Path of the file to load the Document from.
     * @throws FileNotFoundException If the file was not found.
     */
    public void loadDocument(String path) throws FileNotFoundException {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            _document = (Document) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            throw new FileNotFoundException(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
