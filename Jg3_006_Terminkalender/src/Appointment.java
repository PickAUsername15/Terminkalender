
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominik Roth
 */
public class Appointment implements Serializable {

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

    public LocalDate getDate() {
        return LocalDate.of(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth());
    }

    public LocalTime getTime() {
        return LocalTime.of(ldt.getHour(), ldt.getMinute());
    }
    @Override
    public String toString() {
        return String.format("%01d.%01d.%01d - %01d.%01d --> %s", ldt.getDayOfMonth(), ldt.getMonthValue(), ldt.getYear(), ldt.getHour(), ldt.getMinute(), text);
    }

}
