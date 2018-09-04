package org.eclipse.widgets;

import Model.*;
import Model.Object;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import Controller.AnotherController;
import java.util.ArrayList;

import static java.lang.String.valueOf;

    public class NewTable extends Composite {
        public Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION |
                SWT.V_SCROLL | SWT.H_SCROLL);
        public Label countItems = new Label(this, SWT.NONE);
        public Label allItems = new Label(this, SWT.NONE);
        public Label currentPage = new Label(this, SWT.NONE);
        public Label allPages = new Label(this, SWT.NONE);
        public int currentPages=1;
        public int DrawnCurLow = 0;
        public int DrawnCurHigh = 1;
        public int ElemOnPage = 3;

        public NewTable(Composite composite, int i) {
            super(composite, i);
        }

        public void draw(int start, int end, AnotherInfo info) {

            TableColumn[] TableColumns = new TableColumn[info.getObject(0).size()];
            for (int i=0; i<info.getObject(0).size(); i++) {

                TableColumn column = new TableColumn(table, SWT.LEFT, i);
                column.setText(info.getObject(0).get(i).getNameOfParameter());
                column.setWidth(150);
                column.setResizable(true);
                TableColumns[i] = column;
            }
            for (Object object : info.getObjects().subList(start, end)) {
                TableItem tableItem = new TableItem(table, SWT.PUSH);
                for (int i=0; i<info.getObject(0).size(); i++){
                    if(object.get(i).getParameterType().equalsIgnoreCase("Word")){
                        tableItem.setText(i, String.valueOf(object.get(i).getWord()));
                    }
                    if(object.get(i).getParameterType().equalsIgnoreCase("Number")){
                        tableItem.setText(i, String.valueOf(object.get(i).getNumber()));
                    }
                    if(object.get(i).getParameterType().equalsIgnoreCase("Date")){
                        tableItem.setText(i, String.valueOf(object.get(i).getDateD()));
                    }
                }
            }
        }

        public void draw(int start, int end, ArrayList<Object> info) {

            TableColumn[] TableColumns = new TableColumn[info.get(0).size()];

            for (int i=0; i<info.get(0).size(); i++) {
                TableColumn column = new TableColumn(table, SWT.LEFT, i);
                column.setText(info.get(0).get(i).getNameOfParameter());
                column.setWidth(150);
                column.setResizable(true);
                TableColumns[i] = column;
            }
            for (Object object : info.subList(start, end)) {
                TableItem tableItem = new TableItem(table, SWT.PUSH);
                for (int i=0; i<info.get(0).size(); i++){
                    if(object.get(i).getParameterType().equalsIgnoreCase("Word")){
                        tableItem.setText(i, String.valueOf(object.get(i).getWord()));
                    }
                    if(object.get(i).getParameterType().equalsIgnoreCase("Number")){
                        tableItem.setText(i, String.valueOf(object.get(i).getNumber()));
                    }
                    if(object.get(i).getParameterType().equalsIgnoreCase("Date")){
                        tableItem.setText(i, String.valueOf(object.get(i).getDateD()));
                    }
                }
            }
        }

        public void Destroy(){
            table.setRedraw(false);
            while ( table.getColumnCount() > 0 ) {
                table.getColumns()[ 0 ].dispose();
            }
            table.setRedraw(true);
        }
        public void initTable(AnotherInfo info) {
            allPages.setBounds(700, 500, 120, 30);
            allPages.setText("There are " + 1 + " pages");
            currentPage.setBounds(500, 500, 120, 30);
            allItems.setText(info.getObjects().size() + " items at all");
            allItems.setBounds(  160, 360, 200, 30);
            countItems.setText(" items on the page");
            countItems.setBounds(360, 360, 200, 30);
            table.setBounds(20, 50, 892, 300);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);

            Button nextPage = new Button(this, SWT.PUSH);
            nextPage.setText("next page");
            nextPage.setBounds(848, 360, 100, 30);

            Button prevPage = new Button(this, SWT.PUSH);
            prevPage.setText("previous page");
            prevPage.setBounds(728, 360, 100, 30);

            Button lastPage = new Button(this, SWT.PUSH);
            lastPage.setText("Last page");
            lastPage.setBounds(848, 450, 100, 30);

            Button firstPage = new Button(this, SWT.PUSH);
            firstPage.setText("first page");
            firstPage.setBounds(728, 450, 100, 30);

            Text countPages = new Text(this, SWT.CHECK);
            countPages.setBounds(50, 400, 100, 30);
            Label countPagesText = new Label(this, SWT.NONE);
            countPagesText.setText("Input count of elements");
            countPagesText.setBounds(160, 408, 200, 30);

            Button generate = new Button(this, SWT.PUSH);
            generate.setText("generate");
            generate.setBounds(50, 450, 100, 30);

            currentPage.setText("current page is " + 1);

            nextPage.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent selectionEvent) {

                    if (currentPages < info.getObjects().size() / table.getItems().length) {
                        //Увеличить номер в таблице incrementCurrentPages();
                        currentPages ++;
                        Destroy();
                        table.removeAll();
                        draw(DrawnCurHigh, DrawnCurHigh + ElemOnPage, info);
                        DrawnCurLow = DrawnCurHigh;
                        DrawnCurHigh += ElemOnPage;

                    }
                }
            });

            prevPage.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent selectionEvent) {

                    if (currentPages > 1) {
                        //Уменьшить номер в таблице reduceCurrentPages();
                        Destroy();
                        table.removeAll();
                        draw(DrawnCurLow - ElemOnPage, DrawnCurLow, info);
                        DrawnCurHigh = DrawnCurLow;
                        DrawnCurLow -= ElemOnPage;
                    }

                }
            });

            lastPage.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent selectionEvent) {
                    currentPages = info.getObjects().size() / table.getItems().length;
                    Destroy();
                    table.removeAll();
                    draw(info.getObjects().size() - ElemOnPage, info.getObjects().size(), info);
                }
            });

            firstPage.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent selectionEvent) {
                    currentPages = 1;
                    Destroy();
                    table.removeAll();
                    draw(0, ElemOnPage, info);
                }
            });

            generate.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    if (!countPages.getText().isEmpty()) {
                        table.removeAll();
                        Destroy();
                        ElemOnPage = Integer.parseInt(countPages.getText());
                        if (ElemOnPage <= info.getObjects().size()) {
                            draw(0, ElemOnPage, info);
                        }
                    }
                    countItems.setText(ElemOnPage +" items on the page");
                }
            });
        }
        public void clear() {
            table.removeAll();
        }
    }

