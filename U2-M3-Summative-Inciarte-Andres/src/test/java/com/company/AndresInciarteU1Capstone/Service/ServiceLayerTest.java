package com.company.AndresInciarteU1Capstone.Service;

import com.company.AndresInciarteU1Capstone.Dao.*;
import com.company.AndresInciarteU1Capstone.Dto.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    ServiceLayer serviceLayer;

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtDao tshirtDao;

    //Helper Methods
    // Invoice setup
    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImp.class);
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Andres");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("GA");
        invoice.setZipcode("30027");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice.setQuantity(20);
        invoice.setTax(BigDecimal.valueOf(1,2));
        invoice.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice.setTotal(BigDecimal.valueOf(202,2));

        Invoice invoice2 = new Invoice();
        invoice2.setName("Andres");
        invoice2.setStreet("Street");
        invoice2.setCity("City");
        invoice2.setState("GA");
        invoice2.setZipcode("30027");
        invoice2.setItemType("Console");
        invoice2.setItemId(1);
        invoice2.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice2.setQuantity(20);
        invoice2.setTax(BigDecimal.valueOf(1,2));
        invoice2.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice2.setTotal(BigDecimal.valueOf(202,2));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);
        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
    }
    // Console Setup
    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcImp.class);
        Console console = new Console();
        console.setConsoleId(2);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel Core");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(40);

        Console console2 = new Console();
        console2.setModel("PS4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("2TB");
        console2.setProcessor("Intel Core");
        console2.setPrice(BigDecimal.valueOf(400,2));
        console2.setQuantity(40);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console).when(consoleDao).getConsole(2);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
    }
    // Game Setup
    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImp.class);
        Game game = new Game();
        game.setGameId(3);
        game.setTitle("Super Smash Bros");
        game.setEsrbRating("E");
        game.setDescription("great game from nintendo");
        game.setPrice(BigDecimal.valueOf(60,2));
        game.setStudio("Nintendo");
        game.setQuantity(30);

        Game game2 = new Game();
        game2.setTitle("Super Smash Bros");
        game2.setEsrbRating("E");
        game2.setDescription("great game from nintendo");
        game2.setPrice(BigDecimal.valueOf(60,2));
        game2.setStudio("Nintendo");
        game2.setQuantity(30);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(3);
        doReturn(gameList).when(gameDao).allGames();
    }
    // Tshirt Setup
    private void setUpTshirtDaoMock() {
        tshirtDao = mock(TshirtDaoJdbcTemplateImp.class);
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(4);
        tShirt.setSize("S");
        tShirt.setColor("black");
        tShirt.setDescription("just a tshirt");
        tShirt.setPrice(BigDecimal.valueOf(20,2));
        tShirt.setQuantity(30);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("S");
        tShirt2.setColor("black");
        tShirt2.setDescription("just a tshirt");
        tShirt2.setPrice(BigDecimal.valueOf(20,2));
        tShirt2.setQuantity(30);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tShirt);
        doReturn(tShirt).when(tshirtDao).addTshirt(tShirt2);
        doReturn(tShirt).when(tshirtDao).getTshirt(4);
        doReturn(tShirtList).when(tshirtDao).getAllTshirts();
    }

    // ===============================
    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTshirtDaoMock();
        setUpInvoiceDaoMock();

        serviceLayer = new ServiceLayer(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao, tshirtDao);
    }
    // Invoice crud
    @Test
    public void addInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Andres");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("GA");
        invoice.setZipcode("30027");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice.setQuantity(20);
        invoice.setTax(BigDecimal.valueOf(1,2));
        invoice.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice.setTotal(BigDecimal.valueOf(202,2));

        invoiceDao.addInvoice(invoice);
    }

    @Test
    public void getInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Andres");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("GA");
        invoice.setZipcode("30027");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice.setQuantity(20);
        invoice.setSubtotal(BigDecimal.valueOf(150,2));
        invoice.setTax(BigDecimal.valueOf(1,2));
        invoice.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice.setTotal(BigDecimal.valueOf(202,2));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice fromService = serviceLayer.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice, fromService);
    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Andres");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("GA");
        invoice.setZipcode("30027");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice.setQuantity(20);
        invoice.setTax(BigDecimal.valueOf(1,2));
        invoice.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice.setTotal(BigDecimal.valueOf(202,2));

        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList = serviceLayer.getAllInvoices();
        assertEquals(1, invoiceList.size());
        assertEquals(invoice, invoiceList.get(0));
    }

    @Test
    public void deleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(10);
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(invoiceDao).deleteInvoice(integerCaptor.capture());
        serviceLayer.deleteInvoice(10);
        verify(invoiceDao, times(1)).deleteInvoice(integerCaptor.getValue());
        assertEquals(10, integerCaptor.getValue().intValue());
    }

    // Console crud

    @Test
    public void addConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel Core");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(40);

        serviceLayer.addConsole(console);
    }

    @Test
    public void getConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel Core");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(40);

        console = serviceLayer.addConsole(console);

        Console fromService = serviceLayer.getConsole(console.getConsoleId());
        assertEquals(console, fromService);
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel Core");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(40);

        console = serviceLayer.addConsole(console);

        List<Console> consoleList = serviceLayer.getAllConsoles();
        assertEquals(1, consoleList.size());
        assertEquals(console.getPrice(), consoleList.get(0).getPrice());
        assertEquals(console, consoleList.get(0));
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel Core");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(40);

        ArgumentCaptor<Console> itemCaptor = ArgumentCaptor.forClass(Console.class);
        doNothing().when(consoleDao).updateConsole(itemCaptor.capture());
        serviceLayer.updateConsole(console);
        verify(consoleDao, times(1)).updateConsole(itemCaptor.getValue());
        Console console2 = itemCaptor.getValue();
        assertEquals(console, console2);
    }

    @Test
    public void deleteConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel Core");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(40);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(consoleDao).deleteConsole(integerCaptor.capture());
        serviceLayer.deleteConsole(10);
        verify(consoleDao, times(1)).deleteConsole(integerCaptor.getValue());
        console.setConsoleId(10);
        assertEquals(10, integerCaptor.getValue().intValue());
    }

    // Game crud

    @Test
    public void addGame() {
        Game game = new Game();
        game.setTitle("Super Smash Bros");
        game.setEsrbRating("E");
        game.setDescription("great game from nintendo");
        game.setPrice(BigDecimal.valueOf(60,2));
        game.setStudio("Nintendo");
        game.setQuantity(30);

        serviceLayer.addGame(game);
    }

    @Test
    public void getGame() {
        Game game = new Game();
        game.setTitle("Super Smash Bros");
        game.setEsrbRating("E");
        game.setDescription("great game from nintendo");
        game.setPrice(BigDecimal.valueOf(60,2));
        game.setStudio("Nintendo");
        game.setQuantity(30);

        game =serviceLayer.addGame(game);

        Game fromService = serviceLayer.getGame(game.getGameId());
        assertEquals(game, fromService);
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("Super Smash Bros");
        game.setEsrbRating("E");
        game.setDescription("great game from nintendo");
        game.setPrice(BigDecimal.valueOf(60,2));
        game.setStudio("Nintendo");
        game.setQuantity(30);

        game = serviceLayer.addGame(game);

        List<Game> gameList = serviceLayer.getAllGames();
        assertEquals(1, gameList.size());
        assertEquals(game.getPrice(), gameList.get(0).getPrice());
        assertEquals(game, gameList.get(0));
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Super Smash Bros");
        game.setEsrbRating("E");
        game.setDescription("great game from nintendo");
        game.setPrice(BigDecimal.valueOf(60,2));
        game.setStudio("Nintendo");
        game.setQuantity(30);

        ArgumentCaptor<Game> itemCaptor = ArgumentCaptor.forClass(Game.class);
        doNothing().when(gameDao).updateGame(itemCaptor.capture());
        serviceLayer.updateGame(game);
        verify(gameDao, times(1)).updateGame(itemCaptor.getValue());
        Game game2 = itemCaptor.getValue();
        assertEquals(game, game2);
    }

    @Test
    public void deleteGame() {
        Game game = new Game();
        game.setTitle("Super Smash Bros");
        game.setEsrbRating("E");
        game.setDescription("great game from nintendo");
        game.setPrice(BigDecimal.valueOf(60,2));
        game.setStudio("Nintendo");
        game.setQuantity(30);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(gameDao).deleteGame(integerCaptor.capture());
        serviceLayer.deleteGame(10);
        verify(gameDao, times(1)).deleteGame(integerCaptor.getValue());
        game.setGameId(10);
        assertEquals(10, integerCaptor.getValue().intValue());
    }

    // Tshirt crud

    @Test
    public void addTshirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("black");
        tShirt.setDescription("just a tshirt");
        tShirt.setPrice(BigDecimal.valueOf(20,2));
        tShirt.setQuantity(30);

        serviceLayer.addTshirt(tShirt);
    }

    @Test
    public void getATshirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("black");
        tShirt.setDescription("just a tshirt");
        tShirt.setPrice(BigDecimal.valueOf(20,2));
        tShirt.setQuantity(30);

        tShirt = serviceLayer.addTshirt(tShirt);

        TShirt fromService = serviceLayer.getTshirt(tShirt.gettShirtId());
        assertEquals(tShirt, fromService);
    }

    @Test
    public void getAllTshirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("black");
        tShirt.setDescription("just a tshirt");
        tShirt.setPrice(BigDecimal.valueOf(20,2));
        tShirt.setQuantity(30);

        tShirt = serviceLayer.addTshirt(tShirt);

        List<TShirt> tShirtList = serviceLayer.getAllTshirts();
        assertEquals(1, tShirtList.size());
        assertEquals(tShirt.getPrice(), tShirtList.get(0).getPrice());
        assertEquals(tShirt, tShirtList.get(0));
    }

    @Test
    public void updateTshirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("black");
        tShirt.setDescription("just a tshirt");
        tShirt.setPrice(BigDecimal.valueOf(20,2));
        tShirt.setQuantity(30);

        ArgumentCaptor<TShirt> itemCaptor = ArgumentCaptor.forClass(TShirt.class);
        doNothing().when(tshirtDao).updateTshirt(itemCaptor.capture());
        serviceLayer.updateTshirt(tShirt);
        verify(tshirtDao, times(1)).updateTshirt(itemCaptor.getValue());
        TShirt tShirt2 = itemCaptor.getValue();
        assertEquals(tShirt, tShirt2);
    }

    @Test
    public void deleteTshirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("black");
        tShirt.setDescription("just a tshirt");
        tShirt.setPrice(BigDecimal.valueOf(20,2));
        tShirt.setQuantity(30);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(tshirtDao).deleteTshirt(integerCaptor.capture());
        serviceLayer.deleteTshirt(10);
        verify(tshirtDao, times(1)).deleteTshirt(integerCaptor.getValue());
        tShirt.settShirtId(10);
        assertEquals(10, integerCaptor.getValue().intValue());
    }
}