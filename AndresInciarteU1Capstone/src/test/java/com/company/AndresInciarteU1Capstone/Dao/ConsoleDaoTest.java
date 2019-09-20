package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    private Console console, console2;

    @Before
    public void setUp() throws Exception {

        consoleDao.getAllConsoles().forEach(console1 -> {
            consoleDao.deleteConsole(console1.getConsoleId());
        });

        console = new Console();
        console.setModel("PlayStation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Dual core");
        console.setPrice(BigDecimal.valueOf(200,2));
        console.setQuantity(10);

        console2 = new Console();
        console2.setModel("Switch");
        console2.setManufacturer("Nintendo");
        console2.setMemoryAmount("30GB");
        console2.setProcessor("core");
        console2.setPrice(BigDecimal.valueOf(300, 2));
        console2.setQuantity(12);

    }

    @Test
    public void addConsole() {

        console = consoleDao.addConsole(console);

        assertEquals(1, consoleDao.getAllConsoles().size());

    }

    @Test
    public void getConsole() {

        console = consoleDao.addConsole(console);

        Console getConsole = consoleDao.getConsole(console.getConsoleId());

        assertEquals(getConsole, console);

    }

    @Test
    public void getAllConsoles() {

        console = consoleDao.addConsole(console);
        console2 = consoleDao.addConsole(console2);

        List<Console> consoleList = consoleDao.getAllConsoles();

        assertEquals(2, consoleList.size());

    }

    @Test
    public void updateConsole() {

        console = consoleDao.addConsole(console);
        console.setModel("PS4");

        consoleDao.updateConsole(console);

        Console updatedConsole = consoleDao.getConsole(console.getConsoleId());



        assertEquals(console,updatedConsole);
    }

    @Test
    public void deleteConsole() {

        console = consoleDao.addConsole(console);

        consoleDao.deleteConsole(console.getConsoleId());

        Console deletedConsole = consoleDao.getConsole(console.getConsoleId());

        assertNull(deletedConsole);
    }

    @Test
    public void getConsolebyManufacturer() {

        console = consoleDao.addConsole(console);
        console2 = consoleDao.addConsole(console2);

        List<Console> consoleByManuf = consoleDao.getConsoleByManufacturer("Sony");

        assertEquals(1, consoleByManuf.size());
    }
}