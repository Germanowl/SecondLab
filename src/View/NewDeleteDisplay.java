package View;

import Controller.AnotherController;
import Model.WorkObj;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import Model.AnotherInfo;
import org.eclipse.widgets.NewTable;

import java.util.ArrayList;


public class NewDeleteDisplay {
    private Shell shell;
    public AnotherController controller;
    private AnotherInfo info;
    public NewTable tableComposite;

    public NewDeleteDisplay(Display display, AnotherController controller, AnotherInfo info) {
        this.info = info;
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Delete window");
        shell.setSize(1100, 700);
        tableComposite = new NewTable(shell, SWT.NONE);
        this.controller = controller;
        tableComposite.initTable(info);
        tableComposite.setBounds(20, 140, 992, 600);

        initDeleteDisplay();
        shell.open();
    }

    private void initDeleteDisplay() {

        Text NameOfParameter1 = new Text(shell, SWT.CHECK);
        NameOfParameter1.setBounds(10, 10, 150, 30);

        Label NameOfParameter1Text = new Label(shell, SWT.NONE);
        NameOfParameter1Text.setText("Name of first parameter");
        NameOfParameter1Text.setBounds(200, 10, 150, 30);

        Combo TypeOfParameter1 = new Combo(shell, SWT.READ_ONLY);
        TypeOfParameter1.setBounds(10, 50, 150, 30);
        TypeOfParameter1.add("Word");
        TypeOfParameter1.add("Number");
        TypeOfParameter1.add("Date");

        Label TypeOfParameter1Text = new Label(shell, SWT.NONE);
        TypeOfParameter1Text.setText("Type of first parameter");
        TypeOfParameter1Text.setBounds(200, 50, 150, 30);

        Label InnerOfParameter1Text = new Label(shell, SWT.NONE);
        InnerOfParameter1Text.setBounds(200, 100, 150, 15);

        Text InnerOfParameter1W = new Text(shell, SWT.CHECK);

        Text InnerOfParameter1DL = new Text(shell, SWT.CHECK);

        Text InnerOfParameter1DH = new Text(shell, SWT.CHECK);

        Combo TypeOfNumSearch1 = new Combo(shell, SWT.READ_ONLY);

        Text NameOfParameter2 = new Text(shell, SWT.CHECK);
        NameOfParameter2.setBounds(460, 10, 150, 30);

        Label NameOfParameter2Text = new Label(shell, SWT.NONE);
        NameOfParameter2Text.setText("Name of second parameter");
        NameOfParameter2Text.setBounds(650, 10, 150, 30);

        Combo TypeOfParameter2 = new Combo(shell, SWT.READ_ONLY);
        TypeOfParameter2.setBounds(460, 50, 150, 30);
        TypeOfParameter2.add("Word");
        TypeOfParameter2.add("Number");
        TypeOfParameter2.add("Date");

        Label TypeOfParameter2Text = new Label(shell, SWT.NONE);
        TypeOfParameter2Text.setText("Type of second parameter");
        TypeOfParameter2Text.setBounds(650, 50, 150, 30);

        Label InnerOfParameter2Text = new Label(shell, SWT.NONE);
        InnerOfParameter2Text.setBounds(650, 100, 150, 15);

        Text InnerOfParameter2W = new Text(shell, SWT.CHECK);

        Text InnerOfParameter2DL = new Text(shell, SWT.CHECK);

        Text InnerOfParameter2DH = new Text(shell, SWT.CHECK);

        Combo TypeOfNumSearch2 = new Combo(shell, SWT.READ_ONLY);

        Combo AndOr = new Combo(shell, SWT.READ_ONLY);
        AndOr.setBounds(350, 35, 50, 30);
        AndOr.add("And");
        AndOr.add("Or");
        AndOr.add("First");

        Button Delete = new Button(shell, SWT.PUSH);
        Delete.setText("Delete");
        Delete.setBounds(350, 65, 50, 30);
        /////////////////////////////////////////////

        TypeOfParameter1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int idx = TypeOfParameter1.getSelectionIndex();
                if (idx == 0 ){
                    InnerOfParameter1Text.setText("Write word you search");
                    InnerOfParameter1W.setBounds(10, 100, 150, 30);
                }
                else if (idx == 1 ){
                    InnerOfParameter1Text.setText("Play with numbers");

                    InnerOfParameter1DL.setBounds(10, 90, 65, 15);

                    InnerOfParameter1DH.setBounds(85, 90, 65, 15);

                    TypeOfNumSearch1.setBounds(10, 110, 60, 30);
                    TypeOfNumSearch1.add("Low");
                    TypeOfNumSearch1.add("High");
                    TypeOfNumSearch1.add("Both");
                }
                else if (idx == 2 ){
                    InnerOfParameter1Text.setText("Write date");
                    Label InnerOfParameter1TextW = new Label(shell, SWT.NONE);
                    InnerOfParameter1TextW.setBounds(200, 115,180,30);
                    InnerOfParameter1TextW.setText("(EEE, dd MMM yyyy HH:mm:ss z Format)");
                    InnerOfParameter1DL.setBounds(10, 90, 65, 15);
                    InnerOfParameter1DH.setBounds(85, 90, 65, 15);

                    TypeOfNumSearch1.setBounds(10, 110, 60, 30);
                    TypeOfNumSearch1.add("Low");
                    TypeOfNumSearch1.add("High");
                    TypeOfNumSearch1.add("Both");
                }
            }
        });

        TypeOfParameter2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int idx = TypeOfParameter2.getSelectionIndex();
                if (idx == 0 ){
                    InnerOfParameter2Text.setText("Write word you search");

                    InnerOfParameter2W.setBounds(460, 100, 150, 30);
                }
                else if (idx == 1 ){
                    InnerOfParameter2Text.setText("Play with numbers");

                    InnerOfParameter2DL.setBounds(460, 90, 65, 15);

                    InnerOfParameter2DH.setBounds(535, 90, 65, 15);

                    TypeOfNumSearch2.setBounds(460, 110, 60, 30);
                    TypeOfNumSearch2.add("Low");
                    TypeOfNumSearch2.add("High");
                    TypeOfNumSearch2.add("Both");
                }
                else if (idx == 2 ){
                    InnerOfParameter2Text.setText("Write date");
                    Label InnerOfParameter2TextW = new Label(shell, SWT.NONE);
                    InnerOfParameter2TextW.setBounds(650, 115,180,30);
                    InnerOfParameter2TextW.setText("(EEE, dd MMM yyyy HH:mm:ss z Format)");
                    InnerOfParameter2DL.setBounds(460, 90, 65, 15);
                    InnerOfParameter2DH.setBounds(535, 90, 65, 15);

                    TypeOfNumSearch2.setBounds(460, 110, 60, 30);
                    TypeOfNumSearch2.add("Low");
                    TypeOfNumSearch2.add("High");
                    TypeOfNumSearch2.add("Both");
                }
            }
        });

        Delete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0){
                Model.WorkObj First = new Model.WorkObj();
                Model.WorkObj Second = new Model.WorkObj();
                ArrayList<Model.Object> AFirst = new ArrayList<>();
                ArrayList<Model.Object> ASecond = new ArrayList<>();

                int Choice = AndOr.getSelectionIndex();
                if (Choice == 0 || Choice == 1){
                    char StateOfSearch = 'b';
                    if (Choice == 0){StateOfSearch = 'a';}
                    if (Choice == 1){StateOfSearch = 'o';}
                    First.setNameOfParameter(NameOfParameter1.getText());
                    Second.setNameOfParameter(NameOfParameter2.getText());

                    if (TypeOfParameter1.getSelectionIndex() == 0) {
                        First.setWord(InnerOfParameter1W.getText());
                        AFirst = controller.FindOne(First);
                    }
                    if (TypeOfParameter2.getSelectionIndex() == 0) {
                        Second.setWord(InnerOfParameter1W.getText());
                        ASecond = controller.FindOne(Second);
                    }
                    if (TypeOfParameter1.getSelectionIndex() == 1) {

                        char ChosenNumericMode1 = 'a';
                        if(TypeOfNumSearch1.getSelectionIndex() == 0){ChosenNumericMode1 = 'l';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 1){ChosenNumericMode1 = 'h';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 2){ChosenNumericMode1 = 'b';}
                        AFirst = controller.FindNum(NameOfParameter1.getText(),ChosenNumericMode1,Integer.parseInt(InnerOfParameter1DL.getText()),Integer.parseInt(InnerOfParameter1DH.getText()));
                    }
                    if (TypeOfParameter2.getSelectionIndex() == 1) {

                        char ChosenNumericMode2 = 'a';
                        if(TypeOfNumSearch2.getSelectionIndex() == 0){ChosenNumericMode2 = 'l';}
                        else if(TypeOfNumSearch2.getSelectionIndex() == 1){ChosenNumericMode2 = 'h';}
                        else if(TypeOfNumSearch2.getSelectionIndex() == 2){ChosenNumericMode2 = 'b';}
                        ASecond = controller.FindNum(NameOfParameter2.getText(),ChosenNumericMode2,Integer.parseInt(InnerOfParameter2DL.getText()),Integer.parseInt(InnerOfParameter2DH.getText()));

                    }
                    if (TypeOfParameter1.getSelectionIndex() == 2) {
                        char ChosenNumericMode = 'a';
                        if(TypeOfNumSearch1.getSelectionIndex() == 0){ChosenNumericMode = 'l';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 1){ChosenNumericMode = 'h';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 2){ChosenNumericMode = 'b';}
                        WorkObj LowW = new WorkObj();
                        LowW.setDateS(InnerOfParameter1DL.getText());
                        WorkObj HighW = new WorkObj();
                        HighW.setDateS(InnerOfParameter1DH.getText());
                        AFirst = controller.FindDate(NameOfParameter1.getText(),ChosenNumericMode,LowW.getDate(), HighW.getDate());
                    }
                    if (TypeOfParameter2.getSelectionIndex() == 2) {
                        char ChosenNumericMode = 'a';
                        if(TypeOfNumSearch2.getSelectionIndex() == 0){ChosenNumericMode = 'l';}
                        else if(TypeOfNumSearch2.getSelectionIndex() == 1){ChosenNumericMode = 'h';}
                        else if(TypeOfNumSearch2.getSelectionIndex() == 2){ChosenNumericMode = 'b';}
                        WorkObj LowW = new WorkObj();
                        LowW.setDateS(InnerOfParameter2DL.getText());
                        WorkObj HighW = new WorkObj();
                        HighW.setDateS(InnerOfParameter2DH.getText());
                        ASecond = controller.FindDate(NameOfParameter2.getText(),ChosenNumericMode,LowW.getDate(), HighW.getDate());
                    }
                    int Length = controller.FindTwo(AFirst,ASecond,StateOfSearch).size();
                    tableComposite.draw(0, Length, controller.FindTwo(AFirst,ASecond,StateOfSearch));
                    controller.removeAll(controller.FindTwo(AFirst,ASecond,StateOfSearch));
                    //info.getObjects().removeAll(controller.FindTwo(AFirst,ASecond,StateOfSearch));
                }


                if (Choice == 2){
                    First.setNameOfParameter(NameOfParameter1.getText());
                    if (TypeOfParameter1.getSelectionIndex() == 0) {
                        First.setWord(InnerOfParameter1W.getText());
                        int Length = controller.FindOne(First).size();
                        tableComposite.draw(0, Length, controller.FindOne(First));
                        controller.removeAll(controller.FindOne(First));
                        //info.getObjects().removeAll(controller.FindOne(First));

                    }
                    else if (TypeOfParameter1.getSelectionIndex() == 1) {
                        char ChosenNumericMode = 'a';
                        if(TypeOfNumSearch1.getSelectionIndex() == 0){ChosenNumericMode = 'l';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 1){ChosenNumericMode = 'h';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 2){ChosenNumericMode = 'b';}
                        int Length = controller.FindNum(NameOfParameter1.getText(),ChosenNumericMode,Integer.parseInt(InnerOfParameter1DL.getText()),Integer.parseInt(InnerOfParameter1DH.getText())).size();
                        tableComposite.draw(0, Length, controller.FindNum(NameOfParameter1.getText(),ChosenNumericMode,Integer.parseInt(InnerOfParameter1DL.getText()),Integer.parseInt(InnerOfParameter1DH.getText())));
                        controller.removeAll(controller.FindNum(NameOfParameter1.getText(),ChosenNumericMode,Integer.parseInt(InnerOfParameter1DL.getText()),Integer.parseInt(InnerOfParameter1DH.getText())));
                        //info.getObjects().removeAll(controller.FindNum(NameOfParameter1.getText(),ChosenNumericMode,Integer.parseInt(InnerOfParameter1DL.getText()),Integer.parseInt(InnerOfParameter1DH.getText())));
                    }
                    else if (TypeOfParameter1.getSelectionIndex() == 2) {
                        char ChosenNumericMode = 'a';
                        if(TypeOfNumSearch1.getSelectionIndex() == 0){ChosenNumericMode = 'l';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 1){ChosenNumericMode = 'h';}
                        else if(TypeOfNumSearch1.getSelectionIndex() == 2){ChosenNumericMode = 'b';}
                        WorkObj LowW = new WorkObj();
                        LowW.setDateS(InnerOfParameter1DL.getText());
                        WorkObj HighW = new WorkObj();
                        HighW.setDateS(InnerOfParameter1DH.getText());
                        int Length = controller.FindDate(NameOfParameter1.getText(),ChosenNumericMode,LowW.getDate(), HighW.getDate()).size();
                        tableComposite.draw(0,Length,controller.FindDate(NameOfParameter1.getText(),ChosenNumericMode,LowW.getDate(), HighW.getDate()));
                        controller.removeAll(controller.FindDate(NameOfParameter1.getText(),ChosenNumericMode,LowW.getDate(), HighW.getDate()));
                        //info.getObjects().removeAll(controller.FindDate(NameOfParameter1.getText(),ChosenNumericMode,LowW.getDate(), HighW.getDate()));
                    }
                }

            }
        });

    }
}
