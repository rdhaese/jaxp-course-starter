package com.realdolmen.jxp010;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by RDEAX37 on 24/09/2015.
 */
public class PomXMLHandler extends DefaultHandler{

    private boolean inDependencies = false;
    private boolean inDependency = false;
    private boolean inGroupId = false;
    private boolean inArtifactId = false;
    private boolean inVersion = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       if (qName.equals("dependencies")){
           inDependencies = true;
       }else if (inDependencies && qName.equals("dependency")){
           inDependency = true;
       } else  if (inDependencies && inDependency && qName.equals("groupId")){
           inGroupId = true;
       }else  if (inDependencies && inDependency && qName.equals("artifactId")) {
           inArtifactId = true;
       }else  if (inDependencies && inDependency && qName.equals("version")) {
           inVersion = true;
       }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inArtifactId){
            System.out.println(new String(ch, start,length));
        }
        if (inGroupId){

        }
        if (inVersion){

        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
          if (qName.equals("groupId")){
            inGroupId = false;
        }else  if (qName.equals("artifactId")) {
            inArtifactId = true;
        }else  if (qName.equals("version")) {
            inVersion = true;
        } else if (qName.equals("dependencies")){
            inDependencies = false;
        }else if (qName.equals("dependency")){
            inDependency = false;
        }
    }
}
