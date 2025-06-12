package ar.edu.unahur.obj2.observer.observadores.tipoSubastadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class SubastadorUnico extends TipoSubastador {

    private Boolean yaOferto = false;

    public SubastadorUnico(Subastador subastador) {
        super(subastador);
    }

    @Override
    public Oferta ofertar() {
        if (!yaOferto){
            yaOferto = true;
            return new Oferta(subastador, siguienteValor());
        } else{
            return null;
        }
    }

}
