package edt.core;

import edt.exception.FileNotFoundException;
import edt.parser.Parser;

import java.io.*;

/**
 * Created by andre on 11/13/15.
 */
public class Editor {

    private Document _document;
    private Section _section;

    public Editor() {
        String propertyImport = System.getProperty("import");
        if (propertyImport != null) {
            Parser parser = new Parser();
            try {
                _document = parser.parse(propertyImport);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            this._document = new NullDocument();
    }

    public void createDocument() {
        _document = new Document("");
    }

    public void saveDocument() throws FileNotFoundException {
        /* FIXME: IF NO CHANGES WERE DONE DON'T DO SHIT! */
        try {
            FileOutputStream file = new FileOutputStream(_document.getPath());
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(_document);
            out.close();
            file.close();
        } catch (IOException i) {
            throw new FileNotFoundException();
        }
    }

    public void saveNewDocument(String path) throws FileNotFoundException {
        _document.setPath(path);
        saveDocument();
    }

    public void loadDocument(String path) throws FileNotFoundException {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            _document = (Document) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            throw new FileNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return _document;
    }

    public Section getSection() {
        return _section;
    }


}
