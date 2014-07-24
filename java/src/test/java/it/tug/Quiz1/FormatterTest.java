package it.tug.Quiz1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import it.tug.Main.Quiz1.Formatter;
import it.tug.Main.Quiz1.Service;

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
    public void shouldReturnAnErrorMessageIfServiceReturnsNull() {
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
    public void shouldReturnNullIfServiceRepliesDifferentlyThanOKOrFAIL() {
        when(this.service.askForPermission()).thenReturn("luchino");
        
        String actual = sut.doTheJob("foobar");
        
        assertEquals(null, actual);
    }
}
