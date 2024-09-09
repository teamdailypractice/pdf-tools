package com.dailypractice.info.pdfgenerator;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PageConfiguration {
    private String templateFilename;
    private String outputFilename;
    private String pageHeading;
    private String imageFilename;
    private String category;
    private String inputMode;


    public PageConfiguration() {
    }

    public String getTemplateFilename() {
        return templateFilename;
    }

    public void setTemplateFilename(String templateFilename) {
        this.templateFilename = templateFilename;
    }

    public String getOutputFilename() {
        return outputFilename;
    }

    public void setOutputFilename(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    public String getPageHeading() {
        return pageHeading;
    }

    public void setPageHeading(String pageHeading) {
        this.pageHeading = pageHeading;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }


    @Override
    public String toString() {
        return "PageConfiguration{" +
                "templateFilename='" + templateFilename + '\'' +
                ", outputFilename='" + outputFilename + '\'' +
                ", pageHeading='" + pageHeading + '\'' +
                ", imageFilename='" + imageFilename + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageConfiguration that = (PageConfiguration) o;
        return Objects.equals(templateFilename, that.templateFilename) && Objects.equals(outputFilename, that.outputFilename) && Objects.equals(pageHeading, that.pageHeading) && Objects.equals(imageFilename, that.imageFilename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateFilename, outputFilename, pageHeading, imageFilename);
    }
}
