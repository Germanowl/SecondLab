package Model;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class WorkObj {

    private String Word;
    private int Number ;
    private Date Date = new Date();
    private Calendar CDate;
    private String NameOfParameter;
    private String ParameterType;

    public WorkObj(){}


    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setNameOfParameter(String NameofParameter){
        this.NameOfParameter = NameofParameter;
    };

    public String getNameOfParameter (){return NameOfParameter;}

    public void setParameterType(String parameterType) {
        this.ParameterType = parameterType;
    }

    public String getParameterType(){return ParameterType;};

    public long getDate() {
        return Date.getTime();
    }

    public Date getDateD() {
        return Date;
    }

    public int getNumber() {
        return Number;
    }

    public String getWord() {
        return Word;
    }

    public void setDateS(String FormatedDate) {
        String stringDateFormat = "EEE MMM dd HH:mm:ss z yyyy";
        SimpleDateFormat format = new SimpleDateFormat(stringDateFormat, Locale.US);
        try {
            setDate(format.parse(FormatedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDate(long Date) {
        this.Date.setTime(Date);
        this.ParameterType = "Date";
    }

    public void setNumber(int number) {
        this.Number = number;
        this.ParameterType = "Number";
    }

    public void setWord(String Word) {

        this.Word = Word;
        this.ParameterType = "Word";
    }

    public void setDate(String Inside){
        String delimer = "\\.";
        String[] SubStr = new String[2];
        SubStr = Inside.split(delimer);
        setDate(Long.parseLong(SubStr[1]));
        setNameOfParameter(SubStr[0]);
    }

    public void setNumber(String Inside){
        String delimer = "\\.";
        String[] SubStr = new String[2];
        SubStr = Inside.split(delimer);
        setNumber(Integer.parseInt(SubStr[1]));
        setNameOfParameter(SubStr[0]);
    }

    public void setWordD(String Inside){
        String delimer = "\\.";
        String[] SubStr = new String[2];
        SubStr = Inside.split(delimer);
        setWord(SubStr[1]);
        setNameOfParameter(SubStr[0]);
    }
}