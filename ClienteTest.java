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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
// @ActiveProfiles("test")
public class ClienteTest {
    @InjectMocks
    private ClienteController clienteController;
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

    /*@Test
    public void listarTodos() throws Exception {

        when(libroRepository.findAll()).thenReturn(lista());
        libroController.listar();
        verify(libroRepository).findAll();

    }*/

    @Test
    public void guardar() throws Exception {

        Cliente cliente = new Cliente();
        //LibroWS libroWS = new LibroWS();
        cliente.setIdentificacion("test");
        cliente.setNombres("nombre 1");
        cliente.setApellidos("apellido 1");
        cliente.setTelefono("test");
        cliente.setCorreo("cooreo@unl.edu.ec");
        

        //when(librows.cargarDatos(ArgumentMatchers.any(Libro.class))).thenReturn(libro);

        //when(libroRepository.count()).thenReturn(2l);
        clienteController.guardarCliente(cliente);

        verify(clienteRepository).count();

    }

    /**private List<Libro> lista() {
        List<Libro> lista = new ArrayList<>();
        Libro l = new Libro();
        l.setTitulo("java");
        l.setAutores("test 1");
        l.setCodigo("00001");
        l.setExternal_id("1");
        l.setCreateAt(new Date());
        l.setUpdateAt(new Date());
        l.setEdision("test");
        l.setEditorial("test");
        l.setAnio(2022);
        l.setIsbn("test");
        lista.add(l);
        Libro l1 = new Libro();
        l1.setTitulo("java 2");
        l1.setAutores("test 2");
        l1.setCodigo("00002");
        l1.setExternal_id("2");
        l1.setCreateAt(new Date());
        l1.setUpdateAt(new Date());
        l1.setEdision("test");
        l1.setEditorial("test");
        l1.setAnio(2022);
        l1.setIsbn("test");
        lista.add(l1);

        return lista;
    }*/
}
