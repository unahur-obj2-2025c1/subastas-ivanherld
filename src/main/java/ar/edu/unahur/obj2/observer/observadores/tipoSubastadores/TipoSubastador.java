package ar.edu.unahur.obj2.observer.observadores.tipoSubastadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public abstract class TipoSubastador {

    
    protected Subastador subastador;

    protected TipoSubastador(Subastador subastador){
    
        this.subastador = subastador;
    }

    protected Integer siguienteValor() {
        return subastador.getUltimaOfertaRecibida().valor() + 10;
    }

    public abstract Oferta ofertar();
}
