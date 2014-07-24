package it.tug.Main.Quiz3;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class TheServiceTest {

    private TheService sut;
    private FileHandler fileHandler;
    private FooRepository fooRepository;

    @Before
    public void Setup() {
        fileHandler = mock(FileHandler.class);
        fooRepository = mock(FooRepository.class);
        sut = new TheService(fileHandler, fooRepository);
    }


    @Test
    public void shouldReturnEnEmptyStringWhenXmlFileIsEmpty() {
        when(this.fileHandler.getXmlFileFromFileName("blah" )).thenReturn("");
        when(this.fileHandler.getExecutionIdFromFileName("blah" )).thenReturn("1000");
        
        String actual = sut.Execute("blah");
        
        assertEquals("", actual);
    }

    @Test
    public void shouldReturnEnEmptyStringWhenExecutionIdIsEmpty() {
        when(this.fileHandler.getXmlFileFromFileName("blah" )).thenReturn("some_xml_file");
        when(this.fileHandler.getExecutionIdFromFileName("blah" )).thenReturn("");
        
        String actual = sut.Execute("blah");
        
        assertEquals("", actual);
    }

    @Test
    public void shouldElaborateTheFileWithFooWhenExecutionIdAndXmlFileAreFound() {
        when(this.fileHandler.getXmlFileFromFileName("blah" )).thenReturn("some_xml_file");
        when(this.fileHandler.getExecutionIdFromFileName("blah" )).thenReturn("some id");
        Foo foo = new Foo();
        when(this.fooRepository.getFooByXmlFileName("some_xml_file")).thenReturn(foo );
        
        String actual = sut.Execute("blah");
        
        assertEquals("Done things with file blah", actual);
    }
    
}
