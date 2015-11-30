package edt.core;

import java.io.Serializable;

/**
 * TextElement class. Represents a text element.
 */
public abstract class TextElement implements Element, Serializable {

    private String _id;

    /**
     * Returns the number of bytes in the text element.
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
     * Returns the identifier associated with the text element.
     * NOTE: Before calling this please check if the text element
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

    /**
     * Accepts a visitor
     *
     * @param visitor Visitor to accept
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
    
