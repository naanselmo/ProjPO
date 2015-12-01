package edt.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Document class. Represents a document.
 */
public class Document extends Section {

    private final SortedSet<Author> _authors;
    private final Map<String, TextElement> _textElements;
    private String _path;

    /**
     * Initializes a new document with a given title.
     *
     * @param title The title of the document.
     */
    public Document(String title) {
        super(title);
        _authors = new TreeSet<>();
        _textElements = new HashMap<>();
    }

    /**
     * Adds a text element to the document.
     *
     * @param element The text element to add to this document.
     */
    public void indexTextElement(TextElement element) {
        _textElements.put(element.getId(), element);
    }

    /**
     * Checks if a text element associated with a given identifier is in the document.
     *
     * @param id Identifier to verify.
     * @return {@code true} if the text element associated with the given identifier is in this document.
     */
    public boolean containsTextElement(String id) {
        return _textElements.containsKey(id);
    }

    /**
     * Renames the identifier of a text element in the document.
     * If the text element it's not in the document it will add it to the document.
     * If the given identifier already exists in the document, it will overwrite it.
     *
     * @param element Text element to rename.
     * @param id      New identifier of the text element.
     */
    public void renameTextElement(TextElement element, String id) {
        if (element.hasId())
            removeTextElement(element);
        if (containsTextElement(id))
            removeTextElement(getTextElement(id));
        element.setId(id);
        indexTextElement(element);
    }

    /**
     * Removes a text element of the document. Also removes the associated identifier from the text element.
     *
     * @param element The text element that is going to be removed from this document.
     */
    public void removeTextElement(TextElement element) {
        _textElements.remove(element.getId()).removeId();
    }

    /**
     * Returns the text element associated with a given identifier in the document.
     *
     * @param id Identifier of the text element to search for.
     * @return Text element associated with the given identifier.
     */
    public TextElement getTextElement(String id) {
        return _textElements.get(id);
    }

    /**
     * Count of all the text elements associated with an identifier in the document.
     *
     * @return Count of all the text elements associated with an identifier in this document.
     */
    public int getTextElementsCount() {
        return _textElements.size();
    }

    /**
     * Adds an Author to the document.
     *
     * @param author Author to add to this document.
     * @return {@code false} if the author is already associated with this document.
     */
    public boolean addAuthor(Author author) {
        return _authors.add(author);
    }

    /**
     * Returns an iterator with all the authors associated with the document.
     *
     * @return Iterator with all the authors associated with this document.
     */
    public Iterator<Author> getAuthors() {
        return _authors.iterator();
    }

    /**
     * Returns the file path associated with the document.
     *
     * @return The file path of this document.
     */
    public String getPath() {
        return _path;
    }

    /**
     * Sets the file path associated with the document.
     *
     * @param path New file path for this document.
     */
    public void setPath(String path) {
        this._path = path;
    }

    /**
     * Checks if there is a file path associated with the document.
     *
     * @return {@code true} if there is file path associated with this document.
     */
    public boolean hasPath() {
        return getPath() != null;
    }

    /**
     * Calculates a checksum of the document. A String that can represent the whole document
     * and may be used to compare documents or some sort of revision system.
     *
     * @return The checksum of this document.
     * @throws IOException See {@link ObjectOutputStream}.
     */
    public String getChecksum() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.flush();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }
        }
        if (digest != null) {
            digest.update(byteArrayOutputStream.toByteArray());
            return new String(digest.digest());
        }
        /* We know both algorithm exists, so we are pretty sure we are not going to get here */
        return "";
    }

    /**
     * Accepts a visitor.
     *
     * @param visitor Visitor to accept.
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
