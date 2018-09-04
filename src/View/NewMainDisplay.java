package View;

import Controller.AnotherController;
import Model.AnotherInfo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;
import org.eclipse.widgets.NewTable;

import java.io.File;

public class NewMainDisplay {

    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    private AnotherController controller;
    private AnotherInfo info = new AnotherInfo();
    private int count = 0;
    private NewTable tableComposite;

    public NewMainDisplay() {

        Color gray = display.getSystemColor(SWT.COLOR_DARK_GRAY);
        shell.setBackground(gray);
        shell.setText("Lab #2 PPvIS");
        shell.setSize(1100, 650);
        controller = new AnotherController(info);
        centerWindow();
        initFirstWindow();
        tableComposite = new NewTable(shell, SWT.NULL);
        tableComposite.initTable(info);
        tableComposite.setBounds(50, 100, 992, 500);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private void centerWindow() {

        Rectangle rectangle = shell.getDisplay().getBounds();

        Point p = shell.getSize();
        int nLeft = (rectangle.width - p.x) / 2;
        int nTop = (rectangle.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);

    }


    private void initFirstWindow() {

        Button add = new Button(shell, SWT.PUSH);
        add.setBounds(50, 50, 100, 30);
        add.setText("add");
        Button search = new Button(shell, SWT.PUSH);
        search.setBounds(170, 50, 100, 30);
        search.setText("search");
        Button delete = new Button(shell, SWT.PUSH);
        delete.setBounds(290, 50, 100, 30);
        delete.setText("delete");
        Button save = new Button(shell, SWT.PUSH);
        save.setBounds(410, 50, 100, 30);
        save.setText("save");
        Button load = new Button(shell, SWT.PUSH);
        load.setBounds(530, 50, 100, 30);
        load.setText("load");
        Button update = new Button(shell, SWT.PUSH);
        update.setBounds(650, 50, 100, 30);
        update.setText("update");
        /*Button addlist = new Button(shell, SWT.PUSH);
        addlist.setBounds(770, 50, 100, 30);
        addlist.setText("New list");*/

        save.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog fd = new FileDialog(shell, SWT.SAVE);
                fd.setText("Save");
                fd.setFilterPath("C:\\Users\\User\\Desktop\\ppvis4Sem-master\\SecondLab");
                String[] filterExt = {"*.xml"};
                fd.setFilterExtensions(filterExt);
                String selected = fd.open();
                controller.save(new File(selected));
            }
        });

        load.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                FileDialog fd = new FileDialog(shell, SWT.SAVE);
                fd.setText("open");
                fd.setFilterPath("home:/");
                String[] filterExt = {"*.xml"};
                fd.setFilterExtensions(filterExt);
                String selected = fd.open();
                controller.open(new File(selected));
                tableComposite.clear();
                tableComposite.draw(0,tableComposite.ElemOnPage,info);
                tableComposite.allItems.setText(info.getObjects().size() + " items at all");
                tableComposite.countItems.setText(tableComposite.ElemOnPage +" items on the page");
            }
        });

        update.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                tableComposite.clear();
                tableComposite.Destroy();
                tableComposite.draw(0,10,info);
            }
        });

        search.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NewSearchDisplay searchDisplay = new NewSearchDisplay(display, controller, info);
            }
        });

        delete.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NewDeleteDisplay deleteDisplay = new NewDeleteDisplay(display, controller, info);
            }
        });
        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NewAddDisplay addDisplay = new NewAddDisplay(display, controller, info, NewMainDisplay.this);
            }
        });
       /* addlist.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //NewAddListDisplay addlistDisplay = new NewAddListDisplay(display, controller, info, NewMainDisplay.this);
            }
        });*/
    }

}
