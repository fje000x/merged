package com.example.AppointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    @Test
    public void testAddAndDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1", futureDate, "Doctor visit");

        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointments().get("1"));

        service.deleteAppointment("1");
        assertNull(service.getAppointments().get("1"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment1 = new Appointment("1", futureDate, "Doctor visit");
        Appointment appointment2 = new Appointment("1", futureDate, "Dentist visit");

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }
}
