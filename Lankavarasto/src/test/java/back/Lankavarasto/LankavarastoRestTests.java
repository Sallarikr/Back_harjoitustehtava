package back.Lankavarasto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class LankavarastoRestTests {

	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	public void statusOk() throws Exception {
		mockMvc.perform(get("/langat")).andExpect(status().isOk());
		mockMvc.perform(get("/ohjeet")).andExpect(status().isOk());
		mockMvc.perform(get("/varit")).andExpect(status().isOk());
		mockMvc.perform(get("/userit")).andExpect(status().isOk());
	}

	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/langat")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/ohjeet")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/varit")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/userit")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void apiStatusOk() throws Exception {
		mockMvc.perform(get("/api/lankas")).andExpect(status().isOk());
		mockMvc.perform(get("/api/ohjes")).andExpect(status().isOk());
		mockMvc.perform(get("/api/varis")).andExpect(status().isOk());
		mockMvc.perform(get("/api/appUsers")).andExpect(status().isOk());
	}
}
