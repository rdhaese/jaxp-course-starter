package com.realdolmen.jxp010;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class MovieXMLHandler extends org.xml.sax.helpers.DefaultHandler{

    private boolean inMovie = false;
    private boolean inTitle = false;
    private boolean inType = false;
    private boolean inFormat = false;

    private Movie movie;
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        if (s2.equals("movie")){
            inMovie = true;
        }
        if (inMovie && (s1.equals("title"))){
            inTitle = true;
        }
        if (inMovie && (s1.equals("type"))){
            inType  = true;
        }
        if (inMovie && (s1.equals("format"))){
            inFormat = true;
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        if(inMovie) {
            if (!inTitle && !inType && !inFormat){
                movie = new Movie();
            }
            if (inTitle){
                movie.setTitle(new String(chars,i,i1));
            }
            if (inType){
                movie.setType(new String(chars, i, i1));
            }
            if (inFormat){
                movie.setFormat(new String(chars, i, i1));
            }
        }
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        if (inMovie && (s2.equals("movie"))){
            inMovie = false;
            movies.add(movie);
        }
        if (inTitle && (s2.equals("title"))){
            inTitle = false;
        }
        if (inType && (s2.equals("type"))){
            inType = false;
        }
        if (inFormat && (s2.equals("format"))){
            inFormat = false;
        }

    }
}
