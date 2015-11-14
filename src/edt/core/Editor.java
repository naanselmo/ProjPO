package edt.core;

import java.io.*;

/**
 * Created by andre on 11/13/15.
 */
public class Editor {

    private Document _document;

    public void createDocument() {
        _document = new Document("");
    }

    public void saveDocument() {
        try {
            FileOutputStream file = new FileOutputStream(_document.getPath());
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(_document);
            out.close();
            file.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void saveNewDocument(String path) {
        _document.setPath(path);
        saveDocument();
    }

    public void loadDocument(String path) {
        try {
            FileInputStream file = new FileInputStream(_document.getPath());
            ObjectInputStream in = new ObjectInputStream(file);
            _document = (Document) in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

    }

    public Document getDocument() {
        return _document;
    }

}
