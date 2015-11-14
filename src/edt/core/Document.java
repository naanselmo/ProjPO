package edt.core;

import java.io.Serializable;
import java.util.*;

/**
 * Document class. Represents a document.
 */
public class Document extends Section implements Serializable {

    private String _path;
    private SortedSet<Author> _authors;
    private Map<String, TextElement> _textElements;

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
     * Returns the headline of the document.
     *
     * @return The headline of this document.
     */
    @Override
    public String getHeadline() {
        return "{" + getTitle() + "}";
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
}
