package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach; // Para JUnit 5
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;



class ProductoSubatadoTest {

    ProductoSubatado cuadroCaro;
    Subastador gonzager;
    Subastador diazdan;
    Subastador martomau;

    @BeforeEach // Este método se ejecuta antes de cada test
    void setUp() {
        // Inicializar
        cuadroCaro = new ProductoSubatado();

        gonzager = new Subastador();
        diazdan = new Subastador();
        martomau = new Subastador();

        // Le voy a setear los nombres por las dudas
        gonzager.setNombre("gonzager");
        diazdan.setNombre("diazdan");
        martomau.setNombre("martomau");

        // Se le asignan 2 subastadores
        cuadroCaro.agregarObservador(gonzager);
        cuadroCaro.agregarObservador(martomau);
    }

    @Test
    void escenarioDeProductoASubastar() {
        // cuadroCaro.reset();
        // gonzager.resetUltimaOferta();
        // diazdan.resetUltimaOferta();
        // martomau.resetUltimaOferta();

        // martomau realiza la primera oferta
        Oferta primeraOferta = martomau.ofertar(); //Yo no se si esto podría englobarse en el mismo metodo de ofertar()
        cuadroCaro.agregarOferta(primeraOferta);

        // gonzager contraoferta
        Oferta segundaOferta = gonzager.ofertar();
        cuadroCaro.agregarOferta(segundaOferta);

        // martomau realiza la última oferta
        Oferta terceraOferta = martomau.ofertar();
        cuadroCaro.agregarOferta(terceraOferta);

        assertEquals(terceraOferta, gonzager.getUltimaOfertaRecibida());
        assertEquals(terceraOferta, martomau.getUltimaOfertaRecibida());
        assertEquals(martomau,cuadroCaro.getUltimaOfertaRecibida().getSubastador());
        assertEquals(30, cuadroCaro.getUltimaOfertaRecibida().valor());
        assertEquals(3, cuadroCaro.cantidadDeOfertasRecibidas());
        assertThrows(OfertaSubastadorException.class, ()->{
            Oferta cuartaOferta = diazdan.ofertar();
            cuadroCaro.agregarOferta(cuartaOferta);
        }, "El subastador no participa de la subasta");
    }
}
