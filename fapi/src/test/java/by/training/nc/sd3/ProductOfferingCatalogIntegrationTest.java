package by.training.nc.sd3;

import by.training.nc.sd3.controller.ProductOfferingDataController;
import by.training.nc.sd3.security.TokenProvider;
import by.training.nc.sd3.security.WebSecurityConfig;
import by.training.nc.sd3.service.impl.ProductOfferingDataServiceImpl;
import by.training.nc.sd3.service.impl.UserAccountDataServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {ProductOfferingDataController.class})
@ContextConfiguration(classes = {FapiApplication.class, ProductOfferingDataController.class, ProductOfferingDataServiceImpl.class,
        TokenProvider.class, WebSecurityConfig.class, UserAccountDataServiceImpl.class})
public class ProductOfferingCatalogIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    @Test
    public void getAllProductsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(backendServerUrl + "/api/catalog/get")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getFilteredProductsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(backendServerUrl + "/api/catalog/get-by-category?category=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void searchOfferTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(backendServerUrl + "/api/catalog/get-by-name?name=Netflix")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
