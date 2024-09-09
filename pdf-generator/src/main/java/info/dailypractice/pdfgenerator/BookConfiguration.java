package info.dailypractice.pdfgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class BookConfiguration {

    private String bookName;
    private String templateFileAbsolutePath;
    private String outputFileAbsolutePath;

    public BookConfiguration() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTemplateFileAbsolutePath() {
        return templateFileAbsolutePath;
    }

    public void setTemplateFileAbsolutePath(String templateFileAbsolutePath) {
        this.templateFileAbsolutePath = templateFileAbsolutePath;
    }

    public String getOutputFileAbsolutePath() {
        return outputFileAbsolutePath;
    }

    public void setOutputFileAbsolutePath(String outputFileAbsolutePath) {
        this.outputFileAbsolutePath = outputFileAbsolutePath;
    }

    @Override
    public String toString() {
        return "BookConfiguration{" +
                "bookName='" + bookName + '\'' +
                ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
                ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookConfiguration that = (BookConfiguration) o;
        return Objects.equals(bookName, that.bookName) && Objects.equals(templateFileAbsolutePath, that.templateFileAbsolutePath) && Objects.equals(outputFileAbsolutePath, that.outputFileAbsolutePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, templateFileAbsolutePath, outputFileAbsolutePath);
    }
}
