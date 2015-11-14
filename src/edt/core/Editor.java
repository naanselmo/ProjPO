package edt.core;

import edt.exception.*;
import edt.exception.FileNotFoundException;

import java.io.*;

/**
 * Created by andre on 11/13/15.
 */
public class Editor {

    private Document _document;

    public Editor() {
        this._document = new NullDocument();
    }

    public void createDocument() {
        _document = new Document("");
    }

    public void saveDocument() {
        /* FIXME: IF NO CHANGES WERE DONE DON'T DO SHIT! */
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

    public void loadDocument(String path) throws FileNotFoundException {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            _document = (Document) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            throw new FileNotFoundException();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return _document;
    }

}
