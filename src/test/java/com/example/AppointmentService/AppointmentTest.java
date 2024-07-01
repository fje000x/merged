package com.example.AppointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    @Test
    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1", futureDate, "Doctor visit");
        assertEquals("1", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentCreation() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Doctor visit"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(), "Doctor visit"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", pastDate, "Doctor visit"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", new Date(), null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", new Date(), "This description is too long and should throw an exception because it exceeds the limit of fifty characters."));
    }
}
