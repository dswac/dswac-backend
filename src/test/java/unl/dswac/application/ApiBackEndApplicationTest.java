package unl.dswac.application;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;



import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unl.dswac.application.controller.ClienteController;
import unl.dswac.application.model.repository.ClienteRepository;
import unl.dswac.application.model.repository.ReclamoRepository;
import unl.dswac.application.model.repository.TipoReclamoRepository;
import unl.dswac.application.model.repository.UsuarioRepository;
import unl.dswac.application.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiBackEndApplicationTest {

	@InjectMocks
	private ClienteController clienteController;
        
        @Mock
	private ClienteService clienteService;
	
	@Autowired
	private MockMvc mockMvc;
        
	@Autowired
	private ObjectMapper objectMapper;
        
        @Test
    public void listar() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/pin")
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().is2xxSuccessful());

    }

}
