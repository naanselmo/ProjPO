package edt.core;

public abstract class TextElement {

    private String _id;

/**
 * gets the content of a text element
 * @return content of a text element
 */
    public abstract String getContent();

/**
 * gets the number of bytes of a text element
 * @return size of a text element
 */
    public abstract int getSize();

/**
 * verifies if the text element has an ID
 * @return true if it has an ID
 */
    public boolean hasId() {
        return _id != null;
    }

/**
 * removes the id of a text element
 */
    public void removeId() {
        _id = null;
    }

/**
 * gets the id of a text element
 * @return the id of a text element
 */
    public String getId() {
        return _id;
    }

/**
 * defines the id of a text element
 * @param id identifier of a text element
 */
    public void setId(String id) {
        _id = id;
    }

}
    
