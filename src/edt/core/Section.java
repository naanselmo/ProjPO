package edt.core;

import java.util.Iterator;
import java.util.List;

public class Section extends TextElement {

    private String _title;
    private List<Paragraph> _paragraphs;
    private List<Section> _sections;

    public Section(String title) {
    }

    public Section() {
        this(null);
    }

    public String getContent() {
        return null;
    }

    @Override
    public int getSize() {
        return -1;
    }

    public String getHeadline() {
        return null;
    }

    public void addSection(Section section, int index) {
    }

    public boolean containsSection(int index) {
        return false;
    }

    public void renameSection(Document document, int index, String id) {
    }

    public void removeSection(Document document, int index) {
    }

    public int getSectionsCount() {
        return -1;
    }

    public void addParagraph(Paragraph paragraph, int index) {
    }

    public boolean containsParagraph(int index) {
        return false;
    }

    public void renameParagraph(Document document, int index, String id) {
    }

    public void removeParagraph(Document document, int index) {
    }

    public int getParagraphsCount() {
        return -1;
    }

    public Section getSection(int index) {
        return null;
    }

    public Paragraph getParagraph(int index) {
        return null;
    }

    public Iterator<Paragraph> getParagraphs() {
        return null;
    }

    public Iterator<Section> getSections() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public void setTitle(String title) {
    }

}