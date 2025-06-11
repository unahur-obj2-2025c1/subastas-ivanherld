package ar.edu.unahur.obj2.observer.observadores;



import ar.edu.unahur.obj2.observer.Oferta;

public class Subastador implements Observer {
    private String nombreUsuario;
    private Oferta ultimaOfertaRecibida; //En realidad no se si tiene sentido esto, porque la subasta ya tiene el historial de ofertas

    public Oferta ofertar(){
        Oferta oferta = new Oferta();
        oferta.setSubastador(this);
        if ( hayOfertaRecibida()){
            oferta.setValor(this.ultimaOfertaRecibida.valor()+10); //Probar porque seguramente de un error
        } else{
            oferta.setValor(10);
        }
        
        return oferta; 
    }

    public Boolean hayOfertaRecibida(){
        return ultimaOfertaRecibida != null;
    }

    public void setNombre(String nombre){
        this.nombreUsuario = nombre;
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
