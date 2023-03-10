/**
 * 
 */
package com.devpredator.practicajpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Heber
 *
 */
@Entity
@Table(name = "restaurante")
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRestaurante;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "imagen")
	private String imagen;

	@Column(name = "slogan")
	private String slogan;

	// Con consultas lazy vamos a usar objetos basados en proxy.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoRestaurante")
	// Funcion persist unicamente puedo trabajar con INSERT, DELETE y SELECT
	@Cascade(CascadeType.REMOVE)
	private TipoRestaurante tipo_restaurante;

	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;

	@Column(name = "estatus")
	private boolean estatus;
	
	// Con consultas lazy vamos a usar objetos basados en proxy.
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "idMenu")
		// Funcion persist unicamente puedo trabajar con INSERT, DELETE y SELECT
		@Cascade(CascadeType.REMOVE)
		private Menu menu;

		/**
		 * @return the idRestaurante
		 */
		public Long getIdRestaurante() {
			return idRestaurante;
		}

		/**
		 * @param idRestaurante the idRestaurante to set
		 */
		public void setIdRestaurante(Long idRestaurante) {
			this.idRestaurante = idRestaurante;
		}

		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * @return the imagen
		 */
		public String getImagen() {
			return imagen;
		}

		/**
		 * @param imagen the imagen to set
		 */
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		/**
		 * @return the slogan
		 */
		public String getSlogan() {
			return slogan;
		}

		/**
		 * @param slogan the slogan to set
		 */
		public void setSlogan(String slogan) {
			this.slogan = slogan;
		}

		/**
		 * @return the tipo_restaurante
		 */
		public TipoRestaurante getTipo_restaurante() {
			return tipo_restaurante;
		}

		/**
		 * @param tipo_restaurante the tipo_restaurante to set
		 */
		public void setTipo_restaurante(TipoRestaurante tipo_restaurante) {
			this.tipo_restaurante = tipo_restaurante;
		}

		/**
		 * @return the fechaCreacion
		 */
		public LocalDateTime getFechaCreacion() {
			return fechaCreacion;
		}

		/**
		 * @param fechaCreacion the fechaCreacion to set
		 */
		public void setFechaCreacion(LocalDateTime fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		/**
		 * @return the fechaModificacion
		 */
		public LocalDateTime getFechaModificacion() {
			return fechaModificacion;
		}

		/**
		 * @param fechaModificacion the fechaModificacion to set
		 */
		public void setFechaModificacion(LocalDateTime fechaModificacion) {
			this.fechaModificacion = fechaModificacion;
		}

		/**
		 * @return the estatus
		 */
		public boolean isEstatus() {
			return estatus;
		}

		/**
		 * @param estatus the estatus to set
		 */
		public void setEstatus(boolean estatus) {
			this.estatus = estatus;
		}

		/**
		 * @return the menu
		 */
		public Menu getMenu() {
			return menu;
		}

		/**
		 * @param menu the menu to set
		 */
		public void setMenu(Menu menu) {
			this.menu = menu;
		}
		
		

}
