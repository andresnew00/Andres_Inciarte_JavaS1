package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.TShirt;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void getTShirtByIdShouldReturnTShirtWithIdJson() throws Exception {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(1);
        tShirt.setSize("S");
        tShirt.setColor("Blue");
        tShirt.setDescription("Nice");
        tShirt.setPrice(BigDecimal.valueOf(123,2));
        tShirt.setQuantity(11);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(tShirt);


        when(serviceLayer.getTshirt(1)).thenReturn(tShirt);

        this.mockMvc.perform(get("/tshirt/find/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtThatDoesNotExistReturns404() throws Exception {

        // Create a TShirt with no value or id.
        // as that would be the expected behavior if we searched for a non-existant id
        TShirt tShirt = null;

        int idForTShirtThatDoesNotExist = 100;

        when(serviceLayer.getTshirt(idForTShirtThatDoesNotExist)).thenReturn(tShirt);

        this.mockMvc.perform(get("/tshirt/find/" + idForTShirtThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void createTShirtShouldReturnCreatedTShirt() throws Exception {

        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Blue");
        tShirt.setDescription("Nice");
        tShirt.setPrice(BigDecimal.valueOf(123,2));
        tShirt.setQuantity(11);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(tShirt);

        TShirt outputTShirt = new TShirt();
        outputTShirt.settShirtId(1);
        outputTShirt.setSize("S");
        outputTShirt.setColor("Blue");
        outputTShirt.setDescription("Nice");
        outputTShirt.setPrice(BigDecimal.valueOf(123,2));
        outputTShirt.setQuantity(11);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputTShirt);

        when(serviceLayer.addTshirt(tShirt)).thenReturn(outputTShirt);

        this.mockMvc.perform(post("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllTShirtsShouldReturnAListOfTShirts() throws Exception {

        TShirt tShirt = new TShirt();
        tShirt.settShirtId(1);
        tShirt.setSize("S");
        tShirt.setColor("Blue");
        tShirt.setDescription("Nice");
        tShirt.setPrice(BigDecimal.valueOf(123,2));
        tShirt.setQuantity(11);

        TShirt tShirt2 = new TShirt();
        tShirt2.settShirtId(2);
        tShirt2.setSize("S");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("Nice");
        tShirt2.setPrice(BigDecimal.valueOf(123,2));
        tShirt2.setQuantity(11);

        List<TShirt> TShirtList = new ArrayList<>();
        TShirtList.add(tShirt);
        TShirtList.add(tShirt2);

        //Object to JSON in String
        when(serviceLayer.getAllTshirts()).thenReturn(TShirtList);

        List<TShirt> TShirtListChecker = new ArrayList<>();
        TShirtListChecker.addAll(TShirtList);

        String outputJson = mapper.writeValueAsString(TShirtListChecker);

        this.mockMvc.perform(get("/tshirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void updateTShirtShouldReturnAnUpdatedTShirt() throws Exception {

        TShirt tShirt = new TShirt();
        tShirt.settShirtId(1);
        tShirt.setSize("S");
        tShirt.setColor("Blue");
        tShirt.setDescription("Nice");
        tShirt.setPrice(BigDecimal.valueOf(23,2));
        tShirt.setQuantity(11);

        //these will be the same
        String inputJson = mapper.writeValueAsString(tShirt);

        this.mockMvc.perform(put("/tshirt/update/1")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteTShirtIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tshirt/delete/1"))
                .andDo(print()).andExpect(status().isGone())
                .andExpect(content().string(""));
    }

    @Test
    public void findAllTshirtsBySizeWhenGivenASize() throws Exception {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(1);
        tShirt.setSize("S");
        tShirt.setColor("Blue");
        tShirt.setDescription("Nice");
        tShirt.setPrice(BigDecimal.valueOf(123,2));
        tShirt.setQuantity(11);

        TShirt tShirt2 = new TShirt();
        tShirt2.settShirtId(2);
        tShirt2.setSize("S");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("Nice");
        tShirt2.setPrice(BigDecimal.valueOf(123,2));
        tShirt2.setQuantity(11);

        List<TShirt> TShirtList = new ArrayList<>();
        TShirtList.add(tShirt);
        TShirtList.add(tShirt2);

        //Object to JSON in String
        when(serviceLayer.getTShirtsBySize("S")).thenReturn(TShirtList);

        List<TShirt> TShirtListChecker = new ArrayList<>();
        TShirtListChecker.addAll(TShirtList);

        String outputJson = mapper.writeValueAsString(TShirtListChecker);

        this.mockMvc.perform(get("/tshirt/findbysize/S"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
}
