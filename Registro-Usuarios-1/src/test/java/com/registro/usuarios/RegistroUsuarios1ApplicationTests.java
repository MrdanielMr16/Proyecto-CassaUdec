package com.registro.usuarios;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.registro.usuarios.entity.Cartillas;
import com.registro.usuarios.service.CartillasService;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RegistroUsuarios1ApplicationTests {

	@Autowired
	private CartillasService cartillasService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	@Rollback(false)
	void testInsertCartilla() throws IOException {
		File file = new File("D:\\Imagenes y documentos\\Daniel\\ACTA.pdf");
		
		Cartillas cartillas = new Cartillas();
		cartillas.setNombre_archivo(file.getName());
		
		byte[] bytes = Files.readAllBytes(file.toPath());
		cartillas.setContenido(bytes);
		long fileSize = bytes.length;
		cartillas.setTamanio(fileSize);
		cartillas.setFecha_Subida(new Date());
		
		Cartillas GuardarCartilla =  cartillasService.save(cartillas);
		
		Cartillas ExisteCartilla = entityManager.find(Cartillas.class, GuardarCartilla.getId());
		
		assertThat(ExisteCartilla.getTamanio()).isEqualTo(fileSize);
	}

}
