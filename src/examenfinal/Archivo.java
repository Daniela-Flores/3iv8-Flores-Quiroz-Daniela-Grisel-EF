
package examenfinal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Archivo implements Serializable{
    private static final long serialVersionUID = 2L; 
    
    ArrayList<Usuario> listarecuperada = new ArrayList<>();
    
    //aqui es donde tenemos el manejor de archivos por separado
    public ArrayList<Usuario> leer(){
        try{
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Usuarios.txt"));
            
            listarecuperada = (ArrayList<Usuario>)in.readObject();
            
            in.close();
        
        }catch(Exception e){
            System.out.println("Esperando ..... " + e.getMessage());
        
        }
        return listarecuperada;
    }
    
    void serializar(ArrayList<Usuario> listaseriar){
        try{
            
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("Usuarios.txt"));
            objout.writeObject(listaseriar);
            objout.close();
        
        }catch(Exception e){
            System.out.println("Error ... "+ e.getMessage());
        
        }
    }
 
}
