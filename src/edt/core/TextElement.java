package edt.core;

public abstract class TextElement {

    private String _id;

    public abstract String getContent();

    public abstract int getSize();

    public boolean hasId() {
        return _id != null;
    }

    public void removeId() {
        _id = null;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

}
    
