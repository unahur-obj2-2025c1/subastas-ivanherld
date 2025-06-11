package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    private Subastador subastador;
    private Integer valor;

    public void setSubastador(Subastador subastador){
        this.subastador = subastador;
    }

    public void setValor(Integer valor){
        this.valor = valor;
    }

    public Subastador getSubastador(){
        return subastador;
    }

    public Integer valor(){
        return valor;
    }
}
