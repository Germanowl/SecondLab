package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnotherWriterXML {

    private File file;
    private Document document;
    private List<Object> Info = new ArrayList<>();
    private WorkObj Buff;

    public AnotherWriterXML (File file, ArrayList<Object> Info) {
        this.file = file;
        this.Info = Info;
    }
    public AnotherWriterXML(ArrayList<Object> Info) {
        this.Info = Info;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void write() throws TransformerException, ParserConfigurationException {
        if (file != null && Info != null ) {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element Objects = document.createElement("Objects");
            for (Object ObjIter : Info){
                Element Object = document.createElement("Object");
                for(int i=0;i< ObjIter.size();i++){
                    Element WhatContent = document.createElement(ObjIter.get(i).getParameterType());
                    if(ObjIter.get(i).getParameterType().equalsIgnoreCase("Word")){
                        WhatContent.setTextContent(String.valueOf(ObjIter.get(i).getNameOfParameter()) +'.' + String.valueOf(ObjIter.get(i).getWord()));
                    }
                    if(ObjIter.get(i).getParameterType().equalsIgnoreCase("Number")){
                        WhatContent.setTextContent(String.valueOf(ObjIter.get(i).getNameOfParameter()) +'.' + String.valueOf(ObjIter.get(i).getNumber()));
                    }
                    if(ObjIter.get(i).getParameterType().equalsIgnoreCase("Date")){
                        WhatContent.setTextContent(String.valueOf(ObjIter.get(i).getNameOfParameter()) +'.' + String.valueOf(ObjIter.get(i).getDate()));
                    }
                    Object.appendChild(WhatContent);
                }
                Objects.appendChild(Object);

            }

            document.appendChild(Objects);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        }
    }
}
