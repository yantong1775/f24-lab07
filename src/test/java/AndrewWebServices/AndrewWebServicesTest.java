package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AndrewWebServicesTest {
    Database database;
    InMemoryDatabase fakeDatabase;
    RecSys recommender;
    RecSys recommenderStub;
    PromoService promoService;
    PromoService mockEmailService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new Database(); // We probably don't want to access our real database...
        fakeDatabase = new InMemoryDatabase();
        recommender = new RecSys();
        recommenderStub = mock(RecSys.class);
        promoService = new PromoService();
        mockEmailService = mock(PromoService.class);
        andrewWebService = new AndrewWebServices(fakeDatabase, recommenderStub, mockEmailService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        fakeDatabase.savePassword("Scotty", 17214);
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        when(recommenderStub.getRecommendation("Scotty")).thenReturn("Animal House");
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.sendPromoEmail("email");
        verify(mockEmailService).mailTo("email");
    }   

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.sendPromoEmail("not this");
        verify(mockEmailService, never()).mailTo("email");
    }
}
