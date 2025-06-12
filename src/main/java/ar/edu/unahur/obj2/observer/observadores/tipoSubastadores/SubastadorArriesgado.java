package ar.edu.unahur.obj2.observer.observadores.tipoSubastadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class SubastadorArriesgado extends TipoSubastador {
    
    public SubastadorArriesgado(Subastador subastador){
        super(subastador);
    }

    @Override
    public Oferta ofertar() {
        return new Oferta(subastador, siguienteValor()); 
    }
}
