package ua.mateacademy.tania.lesson11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Tania Nebesna on 27.01.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceMockSpyTest {

    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;

    @Mock
    private StringLowerUpperService stringLowerUpperService;

    @Before
    public void setUp(){
        doReturn("startinput").when(stringChangerService).addStart(anyString(), anyString());
        //doReturn("endinput").when(stringChangerService).addEnd(anyString(), anyString());
        when(stringLowerUpperService.toUpper(anyString())).thenReturn("UPPER");
        when(stringLowerUpperService.toLower(anyString())).thenReturn("lower");
    }

    @Test
    public void testAddStartUpperInputLower() {
        String expected = "UPPERlower";
        String actual = stringChangerService.addStartUpperInputLower("smth", "smth");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEnd() {
        String expected = "startinputEND";
        String actual = stringChangerService.addStartAndEnd("smth", "END", "smth");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndWithVerify() {
        stringChangerService.addStartAndEnd("smth", "END", "smth");
        verify(stringChangerService, times(1)).addStart("smth", "smth");
    }

    @Test
    public void testAddStartAndEndUpper() {
        String expected = "startinputUPPER";
        String actual = stringChangerService.addStartAndEndUpper("smth", "END", "smth");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndUpperWithVerify() {
        stringChangerService.addStartAndEndUpper("smth", "END", "smth");
        verify(stringChangerService, times(1)).addStart("smth", "smth");
        verify(stringLowerUpperService,times(1)).toUpper("END");
    }

    @Test
    public void testAddStartAndEndTotalLower() {
        stringChangerService.addStartAndEndTotalLower("start", "END", "input");
        verify(stringLowerUpperService, times(1)).toLower("startinputEND");
    }
}