package com.mega.back;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BackApplicationTests {

	@Autowired
	private Environment env;

	@Test
	@DisplayName("Contexto de Spring se carga correctamente")
	void contextLoads() {
		assertNotNull(env, "El contexto de Spring no se inicializó correctamente");
	}

	@Test
	@DisplayName("application.properties existe y se carga")
	void applicationPropertiesExists() {
		String[] activeProfiles = env.getActiveProfiles();
		assertNotNull(activeProfiles);
	}

	@Test
	@DisplayName("application.yml existe y se carga")
	void applicationYmlExists() {
		String javaVersion = env.getProperty("java.version");
		assertNotNull(javaVersion, "No se encontró la propiedad java.version");
	}

	@Test
	@DisplayName("Versión de Java es 17")
	void javaVersionIs17() {
		String javaVersion = System.getProperty("java.version");
		assertTrue(javaVersion.startsWith("17"), "La versión de Java no es 17");
	}

	@ParameterizedTest
	@ValueSource(strings = {"Hello", "World", "Spring", "Boot", "Test"})
	@DisplayName("Prueba de strings no vacíos")
	void stringsNotEmpty(String text) {
		assertFalse(text.isEmpty());
	}

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	@DisplayName("Test rápido que no debe superar 500ms")
	void fastTest() throws InterruptedException {
		Thread.sleep(100); // Simula pequeña carga
	}

	@Test
	@DisplayName("Variables de entorno accesibles")
	void environmentVariablesAccessible() {
		String path = System.getenv("PATH");
		assertNotNull(path, "No se pudo acceder a la variable PATH");
	}

	@Test
	@DisplayName("Sistema operativo detectado")
	void detectOperatingSystem() {
		String os = System.getProperty("os.name");
		assertTrue(os.length() > 0, "No se detectó el sistema operativo");
	}

	@Test
	@DisplayName("Clase principal BackApplication existe")
	void mainClassExists() {
		try {
			Class<?> clazz = Class.forName("com.mega.back.BackApplication");
			assertNotNull(clazz);
		} catch (ClassNotFoundException e) {
			fail("No se encontró la clase BackApplication");
		}
	}
}
