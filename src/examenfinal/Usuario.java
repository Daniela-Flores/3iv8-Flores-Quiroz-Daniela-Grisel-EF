
package examenfinal;

import java.io.Serializable;


public class Usuario implements Serializable {
    private String nombre;
    private int edad;
    private int puntaje;
    private Integer [] p_partidas;
    
    private Archivo objarchivo = new Archivo();
    
    public Usuario(){
    }
    
    public Usuario(String nombre, int edad, int puntaje, Integer [] p_partidas){
        this.nombre = nombre;
        this.edad = edad;
        this.puntaje = puntaje;
        this.p_partidas = p_partidas;
    }

    
    public String getNombre() {
        return nombre;
    }

  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
    public int getPuntaje() {
        return puntaje;
    }

  
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

   
    public Integer [] getP_partidas() {
        return p_partidas;
    }

 
    public void setP_partidas(Integer [] p_partidas) {
        this.p_partidas = p_partidas;
    }

 
    public Archivo getObjarchivo() {
        return objarchivo;
    }

 
    public void setObjarchivo(Archivo objarchivo) {
        this.objarchivo = objarchivo;
    }
    
    
}
