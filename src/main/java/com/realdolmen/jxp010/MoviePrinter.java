package com.realdolmen.jxp010;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class MoviePrinter {

    public static void main(String[] args){
        SAXParser parser;
        try{
            SAXParserFactory sf = SAXParserFactory.newInstance();
            sf.setNamespaceAware(false);
            sf.setValidating(false);
            parser = sf.newSAXParser();
            MovieXMLHandler mh = new MovieXMLHandler();
            parser.parse(new FileInputStream(new File("C:/Users/rdeax37/Workspaces/Java XML Processing/jaxp-course-starter/src/main/resources/movies.xml")), mh);
            printMovies(mh.getMovies());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMovies(List<Movie> movies) {
        for (Movie movie : movies){
            System.out.println("=========");
            System.out.printf("Movie: \nTitle: %s; Type: %s; Format:%s", movie.getTitle(), movie.getType(), movie.getFormat());
            System.out.println("=========");
        }
    }
}
