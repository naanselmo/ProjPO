package edt.core;

/**
 * Textlement class. Represents a text element.
 */
public abstract class TextElement {

    private String _id;

    /**
     * Returns the text element content.
     *
     * @return The content of this text element.
     */
    public abstract String getContent();

    /**
     * Returns the number of bytes the text element.
     *
     * @return The size in bytes of this text element.
     */
    public abstract int getSize();

    /**
     * Checks if the text element has an identifier associated with it.
     *
     * @return {@code true} if this text element has an identifier with it. Otherwise {@code false}
     */
    public boolean hasId() {
        return getId() != null;
    }

    /**
     * Removes the identifier of this text element.
     */
    public void removeId() {
        _id = null;
    }

    /**
     * Returns the identifier associated with the text element. Before calling this please check if this text element
     * has an identifier associated with it, otherwise null will be returned.
     *
     * @return id The identifier of this text element. Null if it doesn't have any identifier associated to it.
     */
    public String getId() {
        return _id;
    }

    /**
     * Associates the text element with a given identifier.
     *
     * @param id Identifier to associate the text element to.
     */
    public void setId(String id) {
        _id = id;
    }

}
    
