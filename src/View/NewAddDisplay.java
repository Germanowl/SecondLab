package View;

import Model.AnotherInfo;
import Model.Object;
import Model.WorkObj;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

import Controller.AnotherController;

public class NewAddDisplay {
    private Display display;
    private Shell shell;
    private NewMainDisplay mainDisplay;
    private AnotherInfo info;
    private AnotherController controller;

    public NewAddDisplay(Display display, AnotherController controller, AnotherInfo info, NewMainDisplay mainDisplay) {
        this.controller = controller;
        this.mainDisplay = mainDisplay;
        this.info = info;
        this.display = display;
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        Color gray = display.getSystemColor(SWT.COLOR_DARK_GRAY);
        shell.setBackground(gray);
        shell.setText("Add Object");
        shell.setSize(550, 70 + info.getObject(0).size() * 50);
        initAddDisplay();
        shell.open();

    }

    private void initAddDisplay() {

        final int[] NumOfParamNow = new int[1];
        NumOfParamNow[0] = 0;
        Label IntoText = new Label(shell, SWT.NONE);
        IntoText.setText(info.getObject(0).get(NumOfParamNow[0]).getNameOfParameter());
        IntoText.setBounds(270, 50, 250, 30);

        Button add = new Button(shell, SWT.PUSH);
        add.setBounds(140, 10, 250, 30);
        add.setText("Add");

        Text[] Texts = new Text[info.getObject(0).size()];
        Label[] Labels = new Label[info.getObject(0).size()];

        for (int i=0; i<info.getObject(0).size(); i++) {

            Text textie = new Text(shell, SWT.CHECK);
            textie.setBounds(10,i * 40 + 50,250 ,30);
            Texts[i] = textie;

            Label lable = new Label(shell, SWT.NONE);
            lable.setBounds(270, 40 * i + 50, 250, 30);
            lable.setText(info.getObject(0).get(i).getNameOfParameter());
            Labels[i] = lable;

        }

        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Object Total = new Object();

                for (int i=0; i<info.getObject(0).size();i++){
                    WorkObj Tau = new WorkObj();
                    Tau.setNameOfParameter(info.getObject(0).get(i).getNameOfParameter());

                    if( info.getObject(0).get(i).getParameterType().equalsIgnoreCase("Word")){
                        Tau.setWord(Texts[i].getText());
                    }
                    else if( info.getObject(0).get(i).getParameterType().equalsIgnoreCase("Number")){
                        Tau.setNumber(Integer.parseInt(Texts[i].getText()));
                    }
                    else if( info.getObject(0).get(i).getParameterType().equalsIgnoreCase("Date")){
                        Tau.setDateS(Texts[i].getText());
                    }
                    Total.add(Tau);
                    Texts[i].setText("");
                }
                controller.add(Total);
            }

        });

    }

}
