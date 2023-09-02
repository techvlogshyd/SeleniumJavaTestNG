package com.tests;

import com.utils.XMLFileManager;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLFileManagerTest {

    @Test
    public void testXMLFileManager() {
        XMLFileManager xmlFileManager = new XMLFileManager("/Users/prasanna/FrameWork/Automation/src/main/resources/testdata/data.xml");

        // Reading XML
        NodeList nodeList = xmlFileManager.getElementsByTagName("name");
        System.out.println("Name: " + xmlFileManager.getElementTextContent((Element) nodeList.item(0)));

        // Writing XML
        Element newElement = xmlFileManager.createElement("age");
        xmlFileManager.setElementTextContent(newElement, "30");
        xmlFileManager.appendElement((Element) nodeList.item(0).getParentNode(), newElement);
        xmlFileManager.writeXML();
    }
}
