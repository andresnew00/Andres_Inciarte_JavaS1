package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtDaoTest {

    @Autowired
    TshirtDao tshirtDao;

    TShirt tShirt, tShirt2;

    @Before
    public void setUp() throws Exception {

        tshirtDao.getAllTshirts().forEach(tshirt -> {tshirtDao.deleteTshirt(tshirt.gettShirtId());});

        tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Blue");
        tShirt.setDescription("Nice");
        tShirt.setPrice(BigDecimal.valueOf(123,2));
        tShirt.setQuantity(11);

        tShirt2 = new TShirt();
        tShirt2.setSize("XS");
        tShirt2.setColor("Green");
        tShirt2.setDescription("Nice");
        tShirt2.setPrice(BigDecimal.valueOf(123,2));
        tShirt2.setQuantity(11);
    }

    @Test
    public void addTshirt() {
        tShirt = tshirtDao.addTshirt(tShirt);

        assertEquals(1,tshirtDao.getAllTshirts().size());
    }

    @Test
    public void getTshirt() {
        tShirt = tshirtDao.addTshirt(tShirt);

        TShirt getTshirt = tshirtDao.getTshirt(tShirt.gettShirtId());

        assertEquals(getTshirt,tShirt);
    }

    @Test
    public void getAllTshirts() {
        tShirt = tshirtDao.addTshirt(tShirt);
        tShirt2 = tshirtDao.addTshirt(tShirt2);

        List<TShirt> tShirtList = tshirtDao.getAllTshirts();

        assertEquals(2,tShirtList.size());
    }

    @Test
    public void updateTshirt() {
        tShirt = tshirtDao.addTshirt(tShirt);
        tShirt.setDescription("not so nice");

        tshirtDao.updateTshirt(tShirt);

        TShirt updatedTshirt = tshirtDao.getTshirt(tShirt.gettShirtId());

        assertEquals(updatedTshirt,tShirt);
    }

    @Test
    public void deleteTshirt() {
        tShirt = tshirtDao.addTshirt(tShirt);
        tshirtDao.deleteTshirt(tShirt.gettShirtId());

        TShirt deletedTshirt = tshirtDao.getTshirt(tShirt.gettShirtId());

        assertNull(deletedTshirt);
    }

    @Test
    public void getTshirtsByColor() {
        tShirt = tshirtDao.addTshirt(tShirt);
        tShirt2 = tshirtDao.addTshirt(tShirt2);

        List<TShirt> colorTshirts = tshirtDao.getTshirtsByColor("Blue");

        assertEquals(1,colorTshirts.size());
    }

    @Test
    public void getTshirtsBySize() {
        tShirt = tshirtDao.addTshirt(tShirt);
        tShirt2 = tshirtDao.addTshirt(tShirt2);

        List<TShirt> sizeTshirts = tshirtDao.getTshirtsBySize("S");

        assertEquals(1,sizeTshirts.size());

    }
}