package edt.core;

import java.io.Serializable;

/**
 * Author class. Represents an Author.
 */
public class Author implements Element, Comparable<Author>, Serializable {

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

    /**
     * Equality test between the Author and a given object. This will only be true if the object given is an Author,
     * and if they have the same name.
     *
     * @param object Object to compare this author to.
     * @return {@code true} if the object given is internally equal to this author.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Author))
            return false;
        Author author = (Author) object;
        return getName().equals(author.getName());
    }

    /**
     * Returns the hashCode of the author.
     *
     * @return The hashCode of this author.
     */
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * Compares the author with a given one. Will apply the {@link String#compareTo(String)} to compare both
     * author names in order to be performed an alphabetic sort.
     *
     * @param author Author to compare this author to.
     * @return {@link String#compareTo(String)} using this author's name and the other's name.
     */
    @Override
    public int compareTo(Author author) {
        return getName().compareTo(author.getName());
    }

    /**
     * Accepts a visitor
     *
     * @param visitor Visitor to be accepted
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
