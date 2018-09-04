package Controller;

import Model.*;
import org.xml.sax.SAXException;

import javax.naming.Name;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class AnotherController {
    private  AnotherWriterXML writerXML;
    private  AnotherSAXReader saxReader;
    private AnotherInfo info;
    private boolean generate = false;

    public AnotherController(AnotherInfo info){
        this.info = info;
    }

    public void add(Model.Object object){
        info.setObject(object);
    }

    public void removeAll(ArrayList<Model.Object> Massiv){ info.getObjects().removeAll(Massiv);}

    public boolean save(File file) {
        if (writerXML == null)
            writerXML = new AnotherWriterXML(info.getObjects());
        writerXML.setFile(file);
        try {
            writerXML.write();
            return true;
        } catch (TransformerException | ParserConfigurationException e) {
            return false;
        }
    }

    public boolean open(File file) {
        if (saxReader == null) saxReader = new AnotherSAXReader();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, saxReader);
            info.setObjects(saxReader.getObjects());
            return true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Model.Object> FindOne(WorkObj Sample){
        ArrayList<Model.Object> Gotcha = new ArrayList<>();
        for (Model.Object OneElem: info.getObjects()){
            for (int i=0; i<info.getObject(0).size();i++) {
                if (Sample.getNameOfParameter().equalsIgnoreCase(OneElem.get(i).getNameOfParameter())) {
                    if (Sample.getParameterType().equalsIgnoreCase(OneElem.get(i).getParameterType())) {
                        if (Sample.getParameterType().equalsIgnoreCase("Word")){
                            if(Sample.getWord().equalsIgnoreCase(OneElem.get(i).getWord())){
                                Gotcha.add(OneElem);
                            }
                        }
                        else if (Sample.getParameterType().equalsIgnoreCase("Number")){
                            if(Sample.getNumber() == OneElem.get(i).getNumber()){
                                Gotcha.add(OneElem);
                            }
                        }
                        else if (Sample.getParameterType().equalsIgnoreCase("Date")){
                            if(Sample.getDate() == OneElem.get(i).getDate()){
                                Gotcha.add(OneElem);
                            }
                        }
                    }
                }
            }
        }
        return Gotcha;
    }

    public ArrayList<Model.Object> FindNum(String NameOfParameter, char TypeOfSearch, int Low, int High ){
        ArrayList<Model.Object> Gotcha = new ArrayList<>();

            for (Model.Object OneElem: info.getObjects()){
                for (int i=0; i<info.getObject(0).size();i++) {
                    if(NameOfParameter.equalsIgnoreCase(OneElem.get(i).getNameOfParameter())){
                        if(TypeOfSearch == 'b'){
                            if (OneElem.get(i).getNumber() > Low && OneElem.get(i).getNumber() < High){
                                Gotcha.add(OneElem);
                            }
                        }
                        if(TypeOfSearch == 'l'){
                            if (OneElem.get(i).getNumber() > Low){
                                Gotcha.add(OneElem);
                            }
                        }

                        if(TypeOfSearch == 'h'){
                            if (OneElem.get(i).getNumber() < High){
                                Gotcha.add(OneElem);
                            }
                        }
                    }
                }
            }
            return Gotcha;
    }

    public ArrayList<Model.Object> FindDate(String NameOfParameter, char TypeOfSearch, long Low, long High ){
        ArrayList<Model.Object> Gotcha = new ArrayList<>();

        for (Model.Object OneElem: info.getObjects()){
            for (int i=0; i<info.getObject(0).size();i++) {
                if(NameOfParameter.equalsIgnoreCase(OneElem.get(i).getNameOfParameter())){
                    if(TypeOfSearch == 'b'){
                        if (OneElem.get(i).getDate() > Low && OneElem.get(i).getDate() < High){
                            Gotcha.add(OneElem);
                        }
                    }
                    if(TypeOfSearch == 'l'){
                        if (OneElem.get(i).getDate() > Low){
                            Gotcha.add(OneElem);
                        }
                    }

                    if(TypeOfSearch == 'h'){
                        if (OneElem.get(i).getDate() < High){
                            Gotcha.add(OneElem);
                        }
                    }
                }
            }
        }
        return Gotcha;
    }

    public ArrayList<Model.Object> FindTwo (ArrayList<Model.Object> First, ArrayList<Model.Object> Second, char TypeOfSearch){
        ArrayList<Model.Object> Gotcha = new ArrayList<>();
        int SizeOfObj = First.get(0).size();

        if (TypeOfSearch == 'a'){
            ArrayList<Model.Object> AFirst = new ArrayList<>();
            AFirst.addAll(First);
            AFirst.removeAll(Second);
            First.removeAll(AFirst);
            Gotcha.addAll(First);
        }

        else if (TypeOfSearch == 'o'){
            Gotcha.addAll(First);
            Second.removeAll(First);
            Gotcha.addAll(Second);
        }

        return Gotcha;
    }
}
