package unl.dswac.application;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//import com.biblioteca.controladores.LibroRepository;
//import com.biblioteca.modelo.Libro;
//import com.biblioteca.rest.LibroController;
//port com.biblioteca.rest.modelo_rest.LibroWS;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import unl.dswac.application.controller.ClienteController;
import unl.dswac.application.model.Cliente;
import unl.dswac.application.model.repository.ClienteRepository;
import unl.dswac.application.service.ClienteService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
// @ActiveProfiles("test")
public class DannyTest {
    @InjectMocks
    private ClienteController clienteController;
    
    @Mock
    private ClienteService clienteService;
    
    //@Mock
    //private LibroWS librows;
    @Mock
    private ClienteRepository clienteRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void listar() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void listarTodos() throws Exception {

        when(clienteRepository.findAll()).thenReturn(lista());
        clienteRepository.findAll();
        verify(clienteRepository).findAll();

    }

    @Test
    public void guardar() throws Exception {

        Cliente cliente = new Cliente();
        //LibroWS libroWS = new LibroWS();
        cliente.setIdentificacion("test2");
        cliente.setNombres("nombre 1");
        cliente.setApellidos("apellido 1");
        cliente.setTelefono("test");
        cliente.setCorreo("cooreo@unl.edu.ec");
        

        //when(librows.cargarDatos(ArgumentMatchers.any(Libro.class))).thenReturn(libro);

        
        when(clienteController.guardarCliente(cliente)).thenReturn(cliente);        
        clienteController.guardarCliente(cliente);       

        when(clienteRepository.count()).thenReturn(10l);
        
        clienteRepository.count();
        
        verify(clienteRepository).count();

    }

    private List<Cliente> lista() {
        List<Cliente> lista = new ArrayList<>();
        Cliente l = new Cliente();
        l.setIdentificacion("test1");
        l.setNombres("nombre 1");
        l.setApellidos("apellido 1");
        l.setTelefono("test");
        l.setCorreo("cooreo1@unl.edu.ec");
        lista.add(l);
        
        Cliente l1 = new Cliente();
        l1.setIdentificacion("test2");
        l1.setNombres("nombre 2");
        l1.setApellidos("apellido 2");
        l1.setTelefono("test2");
        l1.setCorreo("cooreo2@unl.edu.ec");
        lista.add(l1);

        return lista;
    }
}
