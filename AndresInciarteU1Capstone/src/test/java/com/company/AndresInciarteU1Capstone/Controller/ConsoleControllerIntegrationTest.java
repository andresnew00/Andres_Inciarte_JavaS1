package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Console;
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
@WebMvcTest(ConsoleControllers.class)
public class ConsoleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void getConsoleByIdShouldReturnConsoleWithIdJson() throws Exception {
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("40GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(30);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(console);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(serviceLayer.getConsole(1)).thenReturn(console);

        this.mockMvc.perform(get("/console/find/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleThatDoesNotExistReturns404() throws Exception {

        // Create a Console with no value or id.
        // as that would be the expected behavior if we searched for a non-existant id
        Console console = null;

        int idForConsoleThatDoesNotExist = 100;

        when(serviceLayer.getConsole(idForConsoleThatDoesNotExist)).thenReturn(console);

        this.mockMvc.perform(get("/console/find/" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void createConsoleShouldReturnCreatedConsole() throws Exception {

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("40GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(30);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(console);

        Console outputConsole = new Console();
        outputConsole.setConsoleId(1);
        outputConsole.setModel("PS4");
        outputConsole.setManufacturer("Sony");
        outputConsole.setMemoryAmount("40GB");
        outputConsole.setProcessor("Intel");
        outputConsole.setPrice(BigDecimal.valueOf(400,2));
        outputConsole.setQuantity(30);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputConsole);

        when(serviceLayer.addConsole(console)).thenReturn(outputConsole);

        this.mockMvc.perform(post("/console")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllConsolesShouldReturnAListOfConsoles() throws Exception {

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("40GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(30);

        Console console2 = new Console();
        console2.setConsoleId(2);
        console2.setModel("PS3");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("10GB");
        console2.setProcessor("Intel");
        console2.setPrice(BigDecimal.valueOf(200,2));
        console2.setQuantity(40);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        //Object to JSON in String
        when(serviceLayer.getAllConsoles()).thenReturn(consoleList);

        List<Console> consoleListChecker = new ArrayList<>();
        consoleListChecker.addAll(consoleList);
        //To confirm the test is testing what we think it is... add another Rsvp.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Rsvp(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(consoleListChecker);

        this.mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }



    @Test
    public void updateConsoleShouldReturnAnUpdatedConsole() throws Exception {

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("40GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(30);

        //these will be the same
        String inputJson = mapper.writeValueAsString(console);

        this.mockMvc.perform(put("/console/update/" + console.getConsoleId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteConsoleIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/delete/1"))
                .andDo(print()).andExpect(status().isGone())
                .andExpect(content().string(""));
    }

    @Test
    public void getConsolesByManufacturer() throws Exception {

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("40GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(400,2));
        console.setQuantity(30);

        Console console2 = new Console();
        console2.setConsoleId(2);
        console2.setModel("PS3");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("10GB");
        console2.setProcessor("Intel");
        console2.setPrice(BigDecimal.valueOf(200,2));
        console2.setQuantity(40);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        //Object to JSON in String
        when(serviceLayer.getAllConsoles()).thenReturn(consoleList);

        List<Console> consoleListChecker = new ArrayList<>();
        consoleListChecker.addAll(consoleList);

        String outputJson = mapper.writeValueAsString(consoleListChecker);

        when(serviceLayer.getByManufacturer("Sony")).thenReturn(consoleListChecker);

                this.mockMvc.perform(get("/console/findbymanufacturer/Sony"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().json(outputJson));
    }
}