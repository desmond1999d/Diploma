package by.training.nc.sd3;

import by.training.nc.sd3.controller.BillingAccountDataController;
import by.training.nc.sd3.controller.UserAccountDataController;
import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.security.TokenProvider;
import by.training.nc.sd3.security.WebSecurityConfig;
import by.training.nc.sd3.service.impl.BillingAccountDataServiceImpl;
import by.training.nc.sd3.service.impl.UserAccountDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebMvcTest(value = {UserAccountDataController.class, BillingAccountDataController.class})
@ContextConfiguration(classes = {FapiApplication.class, UserAccountDataController.class, UserAccountDataServiceImpl.class,
        TokenProvider.class, BillingAccountDataServiceImpl.class, WebSecurityConfig.class})
public class UserAccountIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserAccountDataController userAccountDataController;

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    @Test
    public void unauthorizedTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(backendServerUrl + "/api/user-accounts/get-all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/get-by-data?login=1")
                .content("1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void registrationTest() throws Exception {
        UserAccountViewModel user = new UserAccountViewModel();
        user.setName("Test");
        BillingAccountViewModel billingAccountViewModel = new BillingAccountViewModel();
        billingAccountViewModel.setName("fewhfeioffwfwfhoiw");
        billingAccountViewModel.setPassword("fwefwfwefwfwe");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/ba/save")
                .content(objectMapper.writeValueAsBytes(billingAccountViewModel))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/ua/save?activeBillingAccountId=" + billingAccountViewModel.getId())
                .content(objectMapper.writeValueAsBytes(user))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
