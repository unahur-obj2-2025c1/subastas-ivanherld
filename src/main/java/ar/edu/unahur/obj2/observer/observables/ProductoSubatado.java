package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;


public class ProductoSubatado implements Observable{
    private String nombre;
    
    private List<Oferta> historialOfertasRecibidas = new ArrayList<>();
    private Set<Observer> participantes = new HashSet<>();

    public void agregarOferta(Oferta oferta){

        if(!esParticipante(oferta.getSubastador())){
            throw new OfertaSubastadorException("El subastador no participa de la subasta");
        }
        
        historialOfertasRecibidas.add(oferta);
        notificarObservadores();
    }

    public List<Oferta> getHistorialDeOfertas(){
        return historialOfertasRecibidas;
    }

    public Integer cantidadDeOfertasRecibidas(){
        return historialOfertasRecibidas.size();
    }

    public Oferta getUltimaOfertaRecibida(){
        return historialOfertasRecibidas.get(historialOfertasRecibidas.size() - 1);
    }

    public Boolean esParticipante(Observer subastador){
        return participantes.contains(subastador);
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void reset(){
        this.historialOfertasRecibidas = new ArrayList<>();
        this.participantes = new HashSet<>();
    }

    @Override
    public void agregarObservador(Observer observador) {
        participantes.add(observador); 
    }

    @Override
    public void notificarObservadores() {
        participantes.stream().forEach(o -> o.actualizar(getUltimaOfertaRecibida())); 
    }

    @Override
    public void quitarObservador(Observer observador) {
        participantes.remove(observador);
        
    }
}
