package edt.core;

import edt.textui.main.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Section extends TextElement implements Serializable {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private String _title;
    private List<Paragraph> _paragraphs;
    private List<Section> _sections;

    /**
     * Initializes a new Section.
     * @param  title New section's title.
     */
    public Section(String title) {
        _title = title;
        _paragraphs = new ArrayList<>();
        _sections = new ArrayList<>();
    }

    /**
     * Returns the section's content.
     * @return The content.
     */
    public String getContent() {
        StringBuilder output = new StringBuilder();

        output.append(getHeadline()).append(LINE_SEPARATOR);

        for (Paragraph paragraph : _paragraphs)
            output.append(paragraph.getContent()).append(LINE_SEPARATOR);

        for (Section section : _sections)
            output.append(section.getContent()).append(LINE_SEPARATOR);

        return output.toString();
    }

    /**
     * Returns the section's size.
     * @return The size.
     */
    @Override
    public int getSize() {
        int size = _title.length(); // _title.getBytes().length;

        for (Paragraph paragraph : _paragraphs)
            size += paragraph.getSize();

        for (Section section : _sections)
            size += section.getSize();

        return size;
    }

    /**
     * Returns the headline, with its formatting being defined within the {@link edt.textui.main.Message} class.
     * @return The formatted headline.
     */
    public String getHeadline() {
        if (hasId())
            return Message.sectionIndexEntry(getId(), getTitle());
        return Message.sectionIndexEntry("", getTitle());
    }

    /**
     * Adds a new section as a subsection.
     * @param section Section to add.
     * @param index   Index to place it in.
     */
    public void addSection(Section section, int index) {
        if (containsSection(index))
            _sections.add(index, section);
        else
            _sections.add(section);
    }

    /**
     * Checks whether a given section index exists or not.
     * @param  index Index to check for a section.
     * @return       Whether or not it exists.
     */
    public boolean containsSection(int index) {
        return index < _sections.size() && index >= 0;
    }

    /**
     * Renames a given section to have the new name.
     * @param document Document containing the section to be renamed.
     * @param index    Index of the element to be renamed.
     * @param id       New name to give the document.
     */
    public void renameSection(Document document, int index, String id) {
        document.renameTextElement(getSection(index), id);
    }

    /**
     * Deletes a given section.
     * @param document Document from which to remove the section.
     * @param index    Index of the section to be removed.
     */
    public void removeSection(Document document, int index) {
        document.removeTextElement(getSection(index));
    }

    /**
     * Returns the number of sub-sections.
     * @return The number of sections.
     */
    public int getSectionsCount() {
        return _sections.size();
    }

    /**
     * Adds a new paragraph.
     * @param paragraph The paragraph to be added.
     * @param index     Index in which to add the paragraph.
     */
    public void addParagraph(Paragraph paragraph, int index) {
        if (containsParagraph(index))
            _paragraphs.add(index, paragraph);
        else
            _paragraphs.add(paragraph);
    }

    /**
     * Returns whether or not a given paragraph exists.
     * @param  index Index of the paragraph to check for.
     * @return       Whether or not it exists.
     */
    public boolean containsParagraph(int index) {
        return index < _paragraphs.size() && index >= 0;
    }

    /**
     * Renames a given paragraph.
     * @param document Document in which to rename the paragraph.
     * @param index    Index of the paragraph to rename.
     * @param id       New name to give the paragraph.
     */
    public void renameParagraph(Document document, int index, String id) {
        document.renameTextElement(getParagraph(index), id);
    }

    /**
     * Removes a given paragraph.
     * @param document Document in which to remove the paragraph.
     * @param index    Index of the paragraph to remove.
     */
    public void removeParagraph(Document document, int index) {
        document.removeTextElement(getParagraph(index));
    }

    /**
     * Returns the number of paragraphs.
     * @return The number of paragraphs.
     */
    public int getParagraphsCount() {
        return _paragraphs.size();
    }

    /**
     * Returns the section with the given index.
     * @param  index Index of the section to return.
     * @return       The section with a given index.
     */
    public Section getSection(int index) {
        if (containsSection(index))
            return _sections.get(index);

        return null;
    }

    /**
     * Returns the paragraph with the given index.
     * @param  index Index of the paragraph to return.
     * @return       The paragraph with a given index.
     */
    public Paragraph getParagraph(int index) {
        if (containsParagraph(index))
            return _paragraphs.get(index);

        return null;
    }

    /**
     * Returns an iterator for all the paragraphs.
     * @return The iterator for the paragraphs.
     */
    public Iterator<Paragraph> getParagraphs() {
        return _paragraphs.iterator();
    }

    /**
    * Returns an iterator for all the sections.
    * @return The iterator for the sections.
     */
    public Iterator<Section> getSections() {
        return _sections.iterator();
    }

    /**
     * Returns the section's title.
     * @return The title.
     */
    public String getTitle() {
        return _title;
    }

    /**
     * Set's the section's title.
     * @param title The new title.
     */
    public void setTitle(String title) {
        _title = title;
    }

}
