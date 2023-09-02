package com.utils;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XMLFileManager {
    private String filePath;
    private Document document;

    public XMLFileManager(String filePath) {
        this.filePath = filePath;
        this.document = readXML();
    }

    private Document readXML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            return docBuilder.parse(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeXML() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Element createElement(String elementName) {
        return document.createElement(elementName);
    }

    public void appendElement(Element parentElement, Element childElement) {
        parentElement.appendChild(childElement);
    }

    public NodeList getElementsByTagName(String tagName) {
        return document.getElementsByTagName(tagName);
    }

    public String getElementTextContent(Element element) {
        return element.getTextContent();
    }

    public void setElementTextContent(Element element, String textContent) {
        element.setTextContent(textContent);
    }

}

