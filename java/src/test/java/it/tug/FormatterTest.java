package it.tug;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import it.tug.Main.Formatter;
import it.tug.Main.Service;

import org.junit.Before;
import org.junit.Test;

public class FormatterTest {

    private Formatter sut;
    private Service service;

    @Before
    public void setup() {
        service = mock(Service.class);
        sut = new Formatter(service);
    }

    @Test
    public void shouldReturnAnErrorMessageIfServiceReturnsFail() {
        when(this.service.askForPermission()).thenReturn("FAIL");

        String actual = sut.doTheJob("foo");

        assertEquals("error", actual);
    }

    @Test
    public void shouldReturnAnTheStringDoubledIfServiceReturnsOK() {
        when(this.service.askForPermission()).thenReturn("OK");

        String actual = sut.doTheJob("foobar");

        assertEquals("foobarfoobar", actual);
    }
    
    @Test
    public void shouldReturnAnTheStringDoubledIfServiceReturnsOK_AndShouldWorkTwice() {
        when(this.service.askForPermission()).thenReturn("OK");

        String actual;
        
        actual = sut.doTheJob("foobar");
        actual = sut.doTheJob(actual);
        
        assertEquals("foobarfoobarfoobarfoobar", actual);
        
        
    }

    @Test
    public void shouldReturnNullIfServiceRepliesDifferentlyThanOKOrFAIL() {
        when(this.service.askForPermission()).thenReturn("luchino");

        String actual = sut.doTheJob("foobar");

        assertEquals(null, actual);
    }
}
