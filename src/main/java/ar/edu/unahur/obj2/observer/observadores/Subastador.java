package ar.edu.unahur.obj2.observer.observadores;



import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.tipoSubastadores.SubastadorArriesgado;
import ar.edu.unahur.obj2.observer.observadores.tipoSubastadores.TipoSubastador;

public class Subastador implements Observer {
    private final String nombreUsuario;
    private Oferta ultimaOfertaRecibida; //En realidad no se si tiene sentido esto, porque la subasta ya tiene el historial de ofertas
    private TipoSubastador tipoSubastador;

    public Subastador(String userName){
        this.nombreUsuario = userName;
        actualizar(new Oferta(this,0));
        this.tipoSubastador = new SubastadorArriesgado(this);
    }

    public void setTipoSubastador(TipoSubastador tipoSubastador){
        this.tipoSubastador = tipoSubastador;
    }

    public Oferta ofertar(){    
        return this.tipoSubastador.ofertar(); 
    }

    public Boolean hayOfertaRecibida(){
        return ultimaOfertaRecibida != null;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public void resetUltimaOferta(){
        this.ultimaOfertaRecibida = null;
    }

    public void recibirOferta(Oferta oferta){
        this.ultimaOfertaRecibida = oferta;
    }

    public Oferta getUltimaOfertaRecibida(){
        return this.ultimaOfertaRecibida; 
    }

    @Override
    public void actualizar(Oferta oferta) {
        this.recibirOferta(oferta);
    }
    
}
