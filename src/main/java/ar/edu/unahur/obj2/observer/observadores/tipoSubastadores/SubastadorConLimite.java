package ar.edu.unahur.obj2.observer.observadores.tipoSubastadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class SubastadorConLimite extends TipoSubastador {

    private Integer limite;

    public SubastadorConLimite(Subastador subastador, Integer limite) {
        super(subastador);
        this.limite = limite;
    }

    @Override
    public Oferta ofertar() {
        Integer nuevoValor = siguienteValor();
        if(nuevoValor < limite){
            return new Oferta(subastador,nuevoValor);
        } else{
            return null;
        } 
    }
}
