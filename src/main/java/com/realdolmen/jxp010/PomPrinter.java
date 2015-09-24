package com.realdolmen.jxp010;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class PomPrinter {

    public static void main(String... args) {


        SAXParser parser;
        try
        {
            SAXParserFactory sf = SAXParserFactory.newInstance();
            sf.setNamespaceAware(false);
            sf.setValidating(false);
            parser = sf.newSAXParser();
            PomXMLHandler mh = new PomXMLHandler();
            parser.parse(new FileInputStream(new File("C:/Users/rdeax37/Workspaces/Java XML Processing/jaxp-course-starter/src/main/resources/movies.xml")), mh);

        } catch (
                SAXException e
                )

        {
            e.printStackTrace();
        } catch (
                ParserConfigurationException e
                )

        {
            e.printStackTrace();
        } catch (
                IOException e
                )

        {
            e.printStackTrace();
        }
    }
}
