
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominik Roth
 */
public class AppointmentModell extends AbstractListModel {

    private ArrayList<Appointment> appointments = new ArrayList<>();

    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int index) {
        return appointments.get(index);
    }
    
    void add(Appointment a){
        appointments.add(a);
        fireIntervalAdded(this, appointments.size()-1, appointments.size()-1);
    }
     void remove(Appointment a){
        appointments.remove(a);
        fireIntervalRemoved(this, appointments.size()-1, appointments.size()-1);
    }
    
}
