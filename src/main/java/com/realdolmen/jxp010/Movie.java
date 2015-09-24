package com.realdolmen.jxp010;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private String type;
    private String format;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int compareTo(Movie o) {
        return title.compareTo((o.getTitle()));
    }
}
