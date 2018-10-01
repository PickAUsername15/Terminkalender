
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dominik Roth
 */
public class Appointment {
    private String text;
    private LocalDateTime ldt;

    public Appointment(String text, LocalDateTime ldt) {
        this.text = text;
        this.ldt = ldt;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public String getText() {
        return text;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%01d.%01d.%01d - %01d.%01d --> %s", ldt.getDayOfMonth(), ldt.getMonthValue(), ldt.getYear(), ldt.getHour(), ldt.getMinute(), text);
    }
    
    
}
