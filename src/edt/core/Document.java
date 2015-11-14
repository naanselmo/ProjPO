package edt.core;

import java.io.Serializable;
import java.util.*;

public class Document extends Section implements Serializable {

    private String _path;
    private SortedSet<Author> _authors;
    private Map<String, TextElement> _textElements;

/**
 * Creates a new document with a given title.
 * @param  title The title of the document.
 */
    public Document(String title) {
        super(title);
        _authors = new TreeSet<>();
        _textElements = new HashMap<>();
    }

/**
 * Adds a TextElement to the document.
 * @param textElement The TextElement to add to the document.
 */
    public void indexTextElement(TextElement textElement) {
        _textElements.put(textElement.getId(), textElement);
    }

/**
 * Verifies if a TextElement is in the document.
 * @param  id Id to verify.
 * @return    True if a TextElement is in the Document.
 */
    public boolean containsTextElement(String id) {
        return _textElements.containsKey(id);
    }

/**
 * Change the id of a TextElement in the document.
 * @param element TextElement to rename.
 * @param id      New Id of the TextElement.
 */
    public void renameTextElement(TextElement element, String id) {
        if (containsTextElement(id))
            removeTextElement(getTextElement(id));
        element.setId(id);
        indexTextElement(element);
    }

/**
 * Removes a TextElement of a Document
 * @param element The textElement that is going to be removed in the Document.
 */
    public void removeTextElement(TextElement element) {
        _textElements.remove(element.getId()).removeId();
    }

/**
 * Gets a TextElement when given an id.
 * @param  id Id of the TextElement.
 * @return    TextElement.
 */
    public TextElement getTextElement(String id) {
        return _textElements.get(id);
    }

/**
 *Total number of Id's in the document.
 * @return Number of Id's.
 */
    public int getTextElementsCount() {
        return _textElements.size();
    }

    @Override
    public String getHeadline() {
        return "{" + getTitle() + "}";
    }

/**
 * Total number of bytes of a document.
 * @return Size of the document.
 */
    public int getDocumentLength() {
        return getSize();
    }

/**
 * Add's an Author to the document.
 * @param  author Author to add.
 * @return        False if the author already exists.
 */
    public boolean addAuthor(Author author) {
        return _authors.add(author);
    }

/**
 * Gets an iterator to the authors.
 * @return Iterator for the authors.
 */
    public Iterator<Author> getAuthors() {
        return _authors.iterator();
    }

/**
 * Gets the path of the document.
 * @return The path for the file of the document.
 */
    public String getPath() {
        return _path;
    }

/**
 * Defines the path for the document.
 * @param _path Path for the file of the document.
 */
    public void setPath(String _path) {
        this._path = _path;
    }

/**
 * Verifies if there is a Path to a file.
 * @return True if there is Path to a file.
 */
    public boolean hasPath() {
        return _path != null;
    }
}
