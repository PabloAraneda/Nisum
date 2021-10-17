package cl.nisum.rest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cl.nisum.rest.api.data.dto.Phone;
import cl.nisum.rest.api.data.dto.User;
import cl.nisum.rest.api.data.service.UserService;
import cl.nisum.rest.api.rest.controller.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@WithMockUser
public class UserControllerTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		
		List<Phone> phones = new ArrayList<>();
		List<User> users = new ArrayList<User>();
		Phone phone= new Phone(UUID.randomUUID(), 98876655, 1, 12, null);
		phones.add(phone);
		User user = new User(UUID.randomUUID(), "Pablo 1", "pablo1@mail.com", "pablo1", UUID.randomUUID().toString(), null, null, null, null, phones);
		users.add(user);

		Mockito.when(
				this.userService.getAll()).thenReturn(users);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/user/getAll").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		log.info(result.getResponse().toString());
	}


}
