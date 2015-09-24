package com.realdolmen.jxp010;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class PomPrinterDom {

    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document doc = getDocument();
        addNewDependecy(doc);
        sendToOut(doc);
    }

    private static void sendToOut(Document doc) throws TransformerException {
        Transformer t = createTransformer();
        t.transform(new DOMSource(doc), new StreamResult(System.out));
    }

    private static Transformer createTransformer() throws TransformerConfigurationException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        setTransformerProperties(t);
        return t;
    }

    private static void setTransformerProperties(Transformer t) {
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    }

    private static void addNewDependecy(Document doc) {
        NodeList dependencies = doc.getElementsByTagName("dependencies");
        dependencies.item(0).appendChild(newDependency(doc));
    }

    private static Document getDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse("pom.xml");
    }

    private static Node newDependency(Document doc) {
        Node node = doc.createElement("dependency");
        addChildren(doc, node);
        return node;
    }

    private static void addChildren(Document doc, Node node) {
        node.appendChild(createElement(doc, "attributeId", "bla"));
        node.appendChild(createElement(doc, "groupId", "bla"));
        node.appendChild(createElement(doc, "version", "bla"));
    }

    private static Element createElement(Document doc, String tag, String textNode){
        Element element = doc.createElement(tag);
        element.appendChild(doc.createTextNode(textNode));
        return element;
    }
}
