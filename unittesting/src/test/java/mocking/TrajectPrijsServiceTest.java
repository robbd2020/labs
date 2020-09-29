package mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
class TrajectPrijsServiceTest {

    //    @Mock
    private TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService;
    //    @Mock
    private TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService;
    private Reader readerMock;

    private TrajectPrijsService service;

    @BeforeEach
    public void setup() {
        this.service = new TrajectPrijsService();
        this.trajectEenhedenNaarPrijsService = mock(TrajectEenhedenNaarPrijsService.class);
        this.trajectNaarTrajectEenhedenService = mock(TrajectNaarTrajectEenhedenService.class);

        service.setTrajectEenhedenNaarPrijsService(this.trajectEenhedenNaarPrijsService);
        service.setTrajectNaarTrajectEenhedenService(this.trajectNaarTrajectEenhedenService);

    }

    @Test
    void getTrajectPrijs() throws InvalidLocationException {
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(eq("Lochem"), eq("Hengelo"))).thenReturn(3);
        when(trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(eq(3))).thenReturn(4);

        int trajectPrijs = service.getTrajectPrijs("Lochem", "Hengelo");
        assertThat(trajectPrijs, is(12));
    }

    @Test
    void getTrajectPrijsInvalidLocation() throws InvalidLocationException {
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(eq("XX"), anyString())).thenThrow(new InvalidLocationException());
        assertThrows(InvalidLocationException.class, () -> service.getTrajectPrijs("XX", "Hengelo"));
    }

    @Test
    void getTrajectPrijsFromTerminal() throws InvalidLocationException {
        this.readerMock = mock(Reader.class);
        service.setScannerWrapper(this.readerMock);
        when(readerMock.scanLocatie(true)).thenReturn("Lochem");
        when(readerMock.scanLocatie(false)).thenReturn("Hengelo");
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(eq("Lochem"), eq("Hengelo"))).thenReturn(3);
        when(trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(eq(3))).thenReturn(4);
        assertThat(readerMock.scanLocatie(true), containsString("Lochem"));
    }
}
