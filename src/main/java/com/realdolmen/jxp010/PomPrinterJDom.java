package com.realdolmen.jxp010;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class PomPrinterJDom {
    public static void main(String... args) throws IOException, JDOMException {
        Document doc = createDocument();
        addDependency(doc);
        outputDocument(doc);
    }

    private static void addDependency(Document doc) {
        Element root = doc.getRootElement();
        ElementFilter filter = new ElementFilter("dependencies");
        for (Element e : root.getDescendants(filter)){
            e.addContent(createDependency());
            break;
        }
    }

    private static Element createDependency() {
        Element dependency = createDependencyRoot();
        addDependencyElements(dependency);
        return dependency;
    }

    private static void addDependencyElements(Element dependency) {
        dependency.addContent(createElement("attributeId", "blabla"));
        dependency.addContent(createElement("groupId", "blabla"));
        dependency.addContent(createElement("version", "blabla"));
    }

    private static Element createDependencyRoot() {
        Element dependency = new Element("dependency");
        dependency.setNamespace(Namespace.getNamespace("http://maven.apache.org/POM/4.0.0"));
        return dependency;
    }

    private static Element createElement(String name, String text){
        Element element = new Element(name);
        element.setText(text);
        return element;
    }

    private static void outputDocument(Document doc) throws IOException {
        Format format = Format.getPrettyFormat();
        XMLOutputter outputter = new XMLOutputter(format);
        outputter.output(doc, System.out);
    }

    private static Document createDocument() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        return builder.build(new FileInputStream("pom.xml"));
    }
}
