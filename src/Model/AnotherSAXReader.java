package Model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class AnotherSAXReader extends DefaultHandler {

    private boolean bObjects;
    private boolean bObject;
    private boolean bWord;
    private boolean bNumber;
    private boolean bDate;

    private ArrayList Objects;
    private Object Object;
    private WorkObj Sub;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Objects")) {
            bObjects = true;
        } else if (qName.equalsIgnoreCase("Object")) {
            bObject = true;
        } else if (qName.equalsIgnoreCase("Word")) {
            bWord = true;
        } else if (qName.equalsIgnoreCase("Number")) {
            bNumber = true;
        } else if (qName.equalsIgnoreCase("Date")) {
            bDate = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bObjects) {
            Objects = new ArrayList();
            bObjects = false;
        } else if (bObject) {
            Object = new Object();
            bObject = false;
        } else if (bWord) {
            Sub = new WorkObj();
            Sub.setWordD(new String(ch, start, length));
            Object.add(Sub);
            bWord = false;
        } else if (bNumber) {
            Sub = new WorkObj();
            Sub.setNumber(new String(ch, start, length));
            Object.add(Sub);
            bNumber = false;
        } else if (bDate) {
            Sub = new WorkObj();
            Sub.setDate(new String(ch, start, length));
            Object.add(Sub);
            bDate = false;
        }
    }

    public ArrayList<Object> getObjects() {
        return Objects;
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Object")) {
            Objects.add(Object);
            Object = null;
            Sub = null;
        }
    }

}
