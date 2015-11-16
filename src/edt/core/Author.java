package edt.core;

import java.io.Serializable;

/**
 * Author class. Represents an Author.
 */
public class Author implements Comparable<Author>, Serializable {

    private final String _name;
    private final String _email;

    /**
     * Initializes a new Author with the given name and email.
     *
     * @param name  Author's name.
     * @param email Author's email.
     */
    public Author(String name, String email) {
        _name = name;
        _email = email;
    }

    /**
     * Returns the author's name.
     *
     * @return The name of this Author.
     */
    public String getName() {
        return _name;
    }

    /**
     * Returns the author's email.
     *
     * @return The email of this Author.
     */
    public String getEmail() {
        return _email;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Author) {
            Author author = (Author) object;
            return getName().equals(author.getName());
        }
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public int compareTo(Author author) {
        return getName().compareTo(author.getName());
    }

}
