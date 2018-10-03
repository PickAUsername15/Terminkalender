
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominik Roth
 */
public class AppointmentModell extends AbstractTableModel {

    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Appointment> appointmentsSorted = new ArrayList<>();

    @Override
    public int getRowCount() {
        return appointmentsSorted.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object b = null;

        switch (columnIndex) {
            case 0:
                b = appointmentsSorted.get(rowIndex).getDate();
                break;
            case 1:
                b = appointmentsSorted.get(rowIndex).getTime();
                break;
            case 2:
                b = appointmentsSorted.get(rowIndex).getText();
                break;
            default:
                b = "not found";
        }

        return b;
    }

    void add(Appointment a) {
        appointmentsSorted.add(a);
        appointments.add(a);
        fireTableDataChanged();
        sort();
        fireTableDataChanged();
    }

    void remove(Appointment a) {
        appointmentsSorted.remove(a);

        fireTableDataChanged();
        appointments.remove(a);
    }
    
    void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Appointment s : appointmentsSorted) {
            oos.writeObject(s);
        }
    }

    void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object a = null;
        while ((a = ois.readObject()) != null) {
            add((Appointment) a);
        }
    }

    void sort() {
        quicksortAppointment(0, appointmentsSorted.size() - 1);
        fireTableDataChanged();
    }

    void quicksortAppointment(int l, int r) {
        if (l >= r) {
            return;
        }

        LocalDateTime ldt = appointmentsSorted.get(l).getLdt();
        int i = l;
        int j = r;

        while (i <= j) {
            while ((appointmentsSorted.get(i).getLdt().isBefore(ldt)) && (i <= j)) {
                i++;
            }

            while ((appointmentsSorted.get(j).getLdt().isAfter(ldt)) && (i <= j)) {
                j--;
            }

            if (i <= j) {
                Appointment h = appointmentsSorted.get(i);
                appointmentsSorted.set(i, appointmentsSorted.get(j));
                appointmentsSorted.set(j, h);
                i++;
                j--;
            }

        }

        quicksortAppointment(l, j);
        quicksortAppointment(i, r);
    }
}
