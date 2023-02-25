/**
 * 
 */
package com.devpredator.practicajpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.practicajpa.dao.RestauranteDAO;
import com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl;
import com.devpredator.practicajpa.entity.Menu;
import com.devpredator.practicajpa.entity.Restaurante;
import com.devpredator.practicajpa.entity.TipoRestaurante;

/**
 * @author heber
 *
 */
class RestauranteDAOImplTest {

	private RestauranteDAO restauranteDAO = new RestauranteDAOImpl();

	/**
	 * Test method for
	 * {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#guardar(com.devpredator.practicajpa.entity.Restaurante)}.
	 */
	@Test
	void testGuardar() {
		Restaurante restaurante = new Restaurante();
		restaurante.setNombre("Pizza Hut");
		restaurante.setImagen("img");
		restaurante.setSlogan("El gusto de estar juntos");
		restaurante.setFechaCreacion(LocalDateTime.now());
		restaurante.setEstatus(true);

		TipoRestaurante tipo_restaurante = new TipoRestaurante();
		tipo_restaurante.setDescripcion("Estadounidense");
		tipo_restaurante.setFechaCreacion(LocalDateTime.now());
		tipo_restaurante.setEstatus(true);

		Menu menu = new Menu();
		menu.setClave("m1");
		menu.setDescripcion("Menú de pizzas");
		menu.setFechaCreacion(LocalDateTime.now());
		menu.setEstatus(true);

		restaurante.setTipo_restaurante(tipo_restaurante);
		restaurante.setMenu(menu);
		this.restauranteDAO.guardar(restaurante);

	}

	/**
	 * Test method for
	 * {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#actualizar(com.devpredator.practicajpa.entity.Restaurante)}.
	 */
	@Test
	void testActualizar() {
		Restaurante restauranteConsultado = this.restauranteDAO.consultarById(10L);
		restauranteConsultado.setNombre("Burger King");
		restauranteConsultado.getTipo_restaurante().setDescripcion("Estadounidense");
		restauranteConsultado.getMenu().setDescripcion("Menú de hamburguesas");

		this.restauranteDAO.actualizar(restauranteConsultado);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#eliminar(long)}.
	 */
	@Test
	void testEliminar() {
		this.restauranteDAO.eliminar(19L);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Restaurante> restaurantesConsultados = this.restauranteDAO.consultar();
		assertTrue(restaurantesConsultados.size() > 0);

		for (Restaurante restaurante : restaurantesConsultados) {
			System.out.println("Restaurante: " + restaurante.getNombre());
			System.out.println("Tipo de restaurante: " + restaurante.getTipo_restaurante().getDescripcion());
			

		}

	}

	/**
	 * Test method for
	 * {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Restaurante restaurante = this.restauranteDAO.consultarById(12L);

		System.out.println("Restaurante: " + restaurante.getNombre());
	}

}
