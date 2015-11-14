package edt.core;

/**
 * Created by andre on 11/13/15.
 */
public class Editor implements Serializable{

    private Document _document;

    public void createDocument() {
        _document = new Document();
    }

    public void saveDocument() {
        saveNewDocument(_document.getPath());
    }

    public void saveNewDocument(String path){
        _document.setPath(path);
        try{
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(_document);
            out.close();
            file.close();
        }catch(IOException i){
            i.printStackTrace();
        }
    }

    public void loadDocument(String path) {
        try{
            FileInputStream file = new FileInputStream(_document.getPath());
            ObjectInputStream in = new ObjectInputStream(file);
            _document = in.readObject();
            in.close();
            file.close();
        }catch(IOException i){
            i.printStackTrace();
        }

    }

    public Document getDocument() {
        return _document;
    }

}
