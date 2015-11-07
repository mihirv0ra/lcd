import com.google.gson.Gson;
import com.lightningcd.api.Application;
import com.lightningcd.api.exception.DeployApplicationNotFoundException;
import com.lightningcd.api.model.Component;
import com.lightningcd.api.model.DeployApplication;
import com.lightningcd.api.model.Environment;
import com.lightningcd.api.rest.DeployApplicationController;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.xml.transform.Result;
import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



@RunWith(SpringJUnit4ClassRunner.class)
    @SpringApplicationConfiguration(classes = Application.class)
    @WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class DeploymentControllerTest {

    private MockMvc mockMvc;
    private DeployApplication deployApplication=new DeployApplication();
    String jsonString = "";



        @Autowired
        private WebApplicationContext webApplicationContext;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

        @Before
        public void setUp() throws Exception {
            Environment environment = new Environment();
            Component component=new Component();
            environment.setEnvironmentName("QA");
            component.setComponentName("abcdweb");
            component.setComponentType("web");
            component.setComponentVersion("1.0.0.0");
            component.setCpu("1.0");
            component.setMemory("512M");
            Environment[] env={environment};
            Component[] comp={component};
            deployApplication.setApplicationName("abcdApplication");
            deployApplication.setEnvironments(env);
            deployApplication.setComponent(comp);
            deployApplication.setProvisioningTypes("ssh");
            this.mockMvc = webAppContextSetup(webApplicationContext).build();

            }

       public String getJSON(Object obj)
       {
           Gson gson = new Gson();

           // convert java object to JSON format,
           // and returned as JSON formatted string
           String json = gson.toJson(obj);
           return json;
       }

    @Test
    public void Test1CreateApplication() throws Exception {

        jsonString = getJSON(deployApplication);
            System.out.println(jsonString);
            mockMvc.perform(post("/createApplication")
                    .contentType(contentType)
                    .content(jsonString))
                    .andExpect(status().isOk());
        }

    @Test
    public void Test2GetApplication() throws Exception {
        ResultActions actions = mockMvc.perform(get("/getApplication")
                .param("applicationName", "abcdApplication")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.applicationName").value("abcdApplication"));
    }


    @Test
    public void Test3UpdateApplication() throws Exception {
        ResultActions actions = mockMvc.perform(get("/getObjectIdfromApplicationName")
                .param("applicationName", "abcdApplication")
                .contentType(contentType));
        System.out.println(actions.andReturn().getResponse().getContentAsString());
        ObjectId ids = new ObjectId(actions.andReturn().getResponse().getContentAsString());

        deployApplication.setId(ids);
        deployApplication.setApplicationName("amitApplication");

        String jsonString = getJSON(deployApplication);
        System.out.println(jsonString);
        ResultActions actions2 = mockMvc.perform(put("/updateApplication")
                .contentType(contentType)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    public void Test4DeleteApplication() throws Exception {

        mockMvc.perform(get("/deleteApplication")
                .param("applicationName", "abcdApplication"))
                .andExpect(status().isOk())
                .andExpect(content().string("abcdApplication"));
    }

    }

