package info.dailypractice.pdfgenerator;

import java.util.ArrayList;
import java.util.List;

public class BookPage {
    private String title;
    private ArrayList<ArrayList<String>> contents = new ArrayList<>();

    public BookPage() {
    }

    public void add(List<String> lines) {
        contents.add(new ArrayList<>(lines));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ArrayList<String>> getContents() {
        return contents;
    }

}
