package info.dailypractice.pdfgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookPage {
    private String title;
    private ArrayList<ArrayList<String>> contents = new ArrayList<>();
    private ArrayList<Map<String,String>> lineNumberContentMapList = new ArrayList<>();

    public BookPage() {
    }

    public void add(List<String> lines) {
        contents.add(new ArrayList<>(lines));

        Map<String,String> lineNumberContentMap = new HashMap<>();
        lineNumberContentMap.put("lineNumber", "1000");
        for (int i = 0; i < lines.size(); i++) {
            lineNumberContentMap.put("a" + (i + 1), lines.get(i));
        }
        add(lineNumberContentMap);
    }

    private void add(Map<String,String> lineNumberContentMap) {
        lineNumberContentMapList.add(lineNumberContentMap);
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

    public List<Map<String,String>> getLineNumberContentMapList() {
        return lineNumberContentMapList;
    }

}
