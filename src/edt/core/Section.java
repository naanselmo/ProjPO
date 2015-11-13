package edt.core;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import edt.textui.main.*;

public class Section extends TextElement {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private String _title;
    private List<Paragraph> _paragraphs;
    private List<Section> _sections;

    public Section(String title) {
        _title = title;
        _paragraphs = new ArrayList<Paragraph>();
        _sections = new ArrayList<Section>();
    }

    public Section() {
        this(null);
    }

    public String getContent() {
        StringBuilder output = new StringBuilder();

        output.append(getHeadline()).append(LINE_SEPARATOR);

        for(paragraph : _paragraphs)
            output.append(paragraph.getContent()).append(LINE_SEPARATOR);

        for(section : _sections)
            output.append(section.getContent()).append(LINE_SEPARATOR);

        return output.toString();
    }

    @Override
    public int getSize() {
        int size = _title.getBytes().length;

        for(paragraph : _paragraphs)
            size += paragraph.getSize();

        for(section : _sections)
            size += section.getSize();

        return size;
    }

    public String getHeadline() {
        return sectionIndexEntry(getId(), getTitle());
    }

    public void addSection(Section section, int index) {
        _sections.add(index, section);
    }

    public boolean containsSection(int index) {
        return index < _sections.size() && index >= 0;
    }

    public void renameSection(Document document, int index, String id) {
        document.renameTextElement(getSection(index), id);
    }

    public void removeSection(Document document, int index) {
        document.removeTextElement(index);
    }

    public int getSectionsCount() {
        return _sections.size();
    }

    public void addParagraph(Paragraph paragraph, int index) {
        _paragraphs.add(index, paragraph);
    }

    public boolean containsParagraph(int index) {
        return index < _paragraphs.size() && index >= 0;
    }

    public void renameParagraph(Document document, int index, String id) {
        document.renameTextElement(getParagraph(index), id);
    }

    public void removeParagraph(Document document, int index) {
        document.removeTextElement(index);
    }

    public int getParagraphsCount() {
        return _paragraphs.size();
    }

    public Section getSection(int index) {
      if (containsSection(index))
          return _sections.get(index);

      return null;
    }

    public Paragraph getParagraph(int index) {
      if (containsParagraph(index))
          return _paragraphs.get(index);

      return null;
    }

    public Iterator<Paragraph> getParagraphs() {
        return _paragraphs.iterator();
    }

    public Iterator<Section> getSections() {
        return _sections.iterator();
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

}
