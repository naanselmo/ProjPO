package edt.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Section class. Represents a Section.
 */
public class Section extends TextElement implements Element {

    private final List<Paragraph> _paragraphs;
    private final List<Section> _sections;
    private String _title;

    /**
     * Initializes a new Section.
     *
     * @param title Section's title.
     */
    public Section(String title) {
        _title = title;
        _paragraphs = new ArrayList<>();
        _sections = new ArrayList<>();
    }

    /**
     * Returns the section's size.
     *
     * @return The size of this section.
     */
    @Override
    public int getSize() {
        int size = getTitle().length();

        for (Paragraph paragraph : _paragraphs)
            size += paragraph.getSize();

        for (Section section : _sections)
            size += section.getSize();

        return size;
    }

    /**
     * Adds a new subsection to the section.
     *
     * @param section Subsection to add.
     * @param index   Index to place it in. If invalid, appends the subsection to the end.
     */
    public void addSection(Section section, int index) {
        if (containsSection(index))
            _sections.add(index, section);
        else
            _sections.add(section);
    }

    /**
     * Checks whether a given subsection index exists or not in the section.
     *
     * @param index Index to check for a subsection.
     * @return {@code true} if this section contains the subsection with the given index.
     */
    public boolean containsSection(int index) {
        return index < _sections.size() && index >= 0;
    }

    /**
     * Renames the subsection with the given index in the section.
     *
     * @param document Document to be notified the renaming of the subsection.
     * @param index    Index of the subsection to be renamed.
     * @param id       New identifier to give to the subsection.
     */
    public void renameSection(Document document, int index, String id) {
        document.renameTextElement(getSection(index), id);
    }

    /**
     * Deletes the subsection from the section with the given index.
     *
     * @param document Document to be notified the removal of the subsection.
     * @param index    Index of the subsection to be removed.
     */
    public void removeSection(Document document, int index) {
        Section section = getSection(index);
        if (section.hasId())
            document.removeTextElement(section);
        for (int i = section.getParagraphsCount() - 1; i >= 0; i--) {
            section.removeParagraph(document, i);
        }
        for (int i = section.getSectionsCount() - 1; i >= 0; i--) {
            section.removeSection(document, i);
        }
        _sections.remove(section);
    }

    /**
     * Returns the count of subsections in the section.
     *
     * @return The count of subsections in this section.
     */
    public int getSectionsCount() {
        return _sections.size();
    }

    /**
     * Adds a new paragraph to the section.
     *
     * @param paragraph The paragraph to be added.
     * @param index     Index in which to add the paragraph. If invalid, appends the paragraph to the end.
     */
    public void addParagraph(Paragraph paragraph, int index) {
        if (containsParagraph(index))
            _paragraphs.add(index, paragraph);
        else
            _paragraphs.add(paragraph);
    }

    /**
     * Checks whether a given paragraph index exists or not in the section.
     *
     * @param index Index to check for a paragraph.
     * @return {@code true} if this section contains a paragraph with the given index.
     */
    public boolean containsParagraph(int index) {
        return index < _paragraphs.size() && index >= 0;
    }

    /**
     * Renames the paragraph with the given index in the section.
     *
     * @param document Document to be notified the renaming of the paragraph.
     * @param index    Index of the paragraph to be renamed.
     * @param id       New identifier to give to the paragraph.
     */
    public void renameParagraph(Document document, int index, String id) {
        document.renameTextElement(getParagraph(index), id);
    }

    /**
     * Deletes the paragraph from the section with the given index.
     *
     * @param document Document to be notified the removal of the paragraph.
     * @param index    Index of the paragraph to be removed.
     */
    public void removeParagraph(Document document, int index) {
        Paragraph paragraph = getParagraph(index);
        if (paragraph.hasId())
            document.removeTextElement(paragraph);
        _paragraphs.remove(paragraph);
    }

    /**
     * Returns the count of paragraphs in the section.
     *
     * @return The count of paragraphs in this section.
     */
    public int getParagraphsCount() {
        return _paragraphs.size();
    }

    /**
     * Returns the section with the given index in the section.
     *
     * @param index Index of the section to return.
     * @return The section with a given index. Null if the index does not exist.
     */
    public Section getSection(int index) {
        if (containsSection(index))
            return _sections.get(index);

        return null;
    }

    /**
     * Returns the paragraph with the given index in the section.
     *
     * @param index Index of the paragraph to return.
     * @return The paragraph with a given index. Null if the index does not exist.
     */
    public Paragraph getParagraph(int index) {
        if (containsParagraph(index))
            return _paragraphs.get(index);

        return null;
    }

    /**
     * Returns an iterator for all the paragraphs in the section.
     *
     * @return The iterator for the paragraphs in this section.
     */
    public Iterator<Paragraph> getParagraphs() {
        return _paragraphs.iterator();
    }

    /**
     * Returns an iterator for all the subsections in the section.
     *
     * @return The iterator for the subsections in this section.
     */
    public Iterator<Section> getSections() {
        return _sections.iterator();
    }

    /**
     * Returns the section's title.
     *
     * @return The title of this section.
     */
    public String getTitle() {
        return _title;
    }

    /**
     * Set's the section's title.
     *
     * @param title The new title for this section.
     */
    public void setTitle(String title) {
        _title = title;
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
