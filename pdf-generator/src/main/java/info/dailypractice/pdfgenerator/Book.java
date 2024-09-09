package info.dailypractice.pdfgenerator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private ArrayList<BookPage> bookPages = new ArrayList<>();

    public Book() {
    }

    public void addBookPages() {
        bookPages.add(getPage("First"));
        bookPages.add(getPage("Second"));
        bookPages.add(getPage("Third"));
    }

    public List<BookPage> getBookPages() {

        return bookPages;
    }

    private BookPage getPage(String title) {
        BookPage page = new BookPage();
        page.setTitle(title);
        for (int i = 0; i < 10; i++) {
            ArrayList<String> contents = new ArrayList<>();
            contents.add(String.valueOf(i));
            contents.add("Line");
            page.add(contents);
        }
        return page;
    }
}
