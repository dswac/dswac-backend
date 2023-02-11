package unl.dswac.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@Column(name = "fecha_reclamo")
	private Date fechaReclamo;
	@Column(name = "comentario")
	private String comentario;
	@OneToOne
	@JoinColumn(name = "id_tipo_reclamo")
	private TipoReclamo tipoReclamo;
	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Reclamo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaReclamo() {
		return fechaReclamo;
	}

	public void setFechaReclamo(Date fechaReclamo) {
		this.fechaReclamo = fechaReclamo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public TipoReclamo getTipoReclamo() {
		return tipoReclamo;
	}

	public void setTipoReclamo(TipoReclamo tipoReclamo) {
		this.tipoReclamo = tipoReclamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
