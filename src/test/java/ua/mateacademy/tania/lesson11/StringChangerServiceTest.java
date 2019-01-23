package ua.mateacademy.tania.lesson11;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Tania Nebesna on 22.01.2019.
 */

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceTest {

    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;

    @Mock
    private StringLowerUpperService stringLowerUpperService;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    public void addStart() {
    }

    @Test
    public void addEnd() {
    }

    @Test
    public void testAddStartUpperInputLower() {
        //when(stringLowerUpperService.toLower(Mockito.anyString())).thenReturn("lowervalue");
        //when(stringLowerUpperService.toUpper(Mockito.anyString())).thenReturn("UPPERVALUE");
        doReturn("lowervalue").when(stringLowerUpperService).toLower(anyString());
        doReturn("UPPERVALUE").when(stringLowerUpperService).toUpper(anyString());
        String expected = "UPPERVALUElowervalue";
        String actual = stringChangerService.addStartUpperInputLower("start", "input");
        assertEquals(expected, actual);
    }

    @Test
    public void addStartAndEnd() {
        doReturn("startinput").when(stringChangerService).addStart(anyString(), anyString());
        String expected = "startinputend";
        String actual = stringChangerService.addStartAndEnd("some", "end", "some");
        assertEquals(expected, actual);
    }

    @Test
    public void addStartAndEndUpper() {
        doReturn("start").when(stringChangerService).addStart("start", "input");
        doReturn("UPPERVALUE").when(stringLowerUpperService).toUpper("end");
        String expected = "startUPPERVALUE";
        String actual = stringChangerService.addStartAndEndUpper("start", "end", "input");
        assertEquals(expected, actual);
    }

    @Test
    public void addStartAndEndUpperWithVerify() {
        doReturn("startinput").when(stringChangerService).addStart("start", "input");
        doReturn("UPPERVALUE").when(stringLowerUpperService).toUpper("end");
        String expected = "startinputUPPERVALUE";
        String actual = stringChangerService.addStartAndEndUpper("start", "end", "input");
        verify(stringLowerUpperService, times(1)).toUpper(Mockito.anyString());
    }

    @Test
    public void addStartAndEndTotalLower() {
        doReturn("startinput").when(stringChangerService).addStart("start", "input");
        stringChangerService.addStartAndEndTotalLower("start", "end", "input");
        verify(stringLowerUpperService).toLower("startinputend");
    }
}