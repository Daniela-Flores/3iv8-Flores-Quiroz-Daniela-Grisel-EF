
package examenfinal;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Celda extends JButton{
    private int x;
    private int y;
    private int tipo;
    private boolean visible;
    private boolean ganar;
    private Color color[];
    
    
    //Constructores
    public Celda(){
        
    }
    
    public Celda(int x, int y) {
        //Se inicializan los atributos de la celda (Botón)
        this.x = x;
        this.y = y;
        this.color = new Color[]{Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.LIGHT_GRAY};
        this.visible = false;
        this.setMinimumSize(new Dimension(50,20));
       this.setBackground(new Color(0,0,0));
        this.setFont(new java.awt.Font("Eras Medium ITC", 1, 12));
        this.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                celdaActionPerformed(evt);
            }
        }
        );
    }
    
    //Evento
    private void celdaActionPerformed(java.awt.event.ActionEvent evt){
      clic();
      
    }

    //Lo que ocurre al hacer clic
    public void clic(){
        System.out.println("clic");
        if (!visible&& ganar==false){
            this.visible=true;
            this.setBackground(new Color(37, 37, 37));
            switch (this.tipo){
               //SI ES UNA CELDA CON MINA (TIPO 0)
                case 0:
                     Juego obj = new Juego();
                            this.setBackground(new Color(225, 225, 225));
                            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mina.png")));
                 obj.perder(obj.getMinas());
                 break;
                 
                 //SI LA CELDA TIENE UNA PISTA
                case 1:
                 //Recorre celdas alrededor de la seleccionada y cuenta minas
                int cont=0;
                this.setIcon(null);
                for (int i=-1; i <=1 ; i++){
                     if(x+i>=0&&x+i<12){
                         for (int j=-1; j<=1;j++){
                             if((y+j>=0&&(y+j)<12)&&Juego.celda[x+i][y+j].getTipo()==0){
                                 cont++;
                             }
                         }
                     }
                 }
                this.setText(" "+cont);
                this.setForeground(this.color[cont]);
                break;
                 
                //SI ES UNA CELDA VACÍA
                default:
                 //Descubre las celdas mientras no sean mina
                    for (int i= -1; i<=1; i++){
                        if(x+i>=0&&x+i<12){
                            for (int j=-1; j<=1; j++){
                                if((y+j>=0&&(y+j)<12)&&Juego.celda[x+i][y+j].getTipo()!=0){
                                    if(!Juego.celda[x+i][y+j].getVisible()){
                                        Juego.celda[x+i][y+j].clic();
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
    
    public int contar(){
       Juego obj = new Juego();
        int cont=0;
        for (int i = 0; i<obj.getFilas(); i++ ){
            for (int j = 0; j <obj.getColumnas(); j++) {
                if (Juego.celda[i][j].getVisible()==true){
                    cont++;
                     JOptionPane.showMessageDialog(null, ""+cont);
                }
            }
        }
        return cont;
    }
   
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public boolean getVisible() {
        return visible;
    }


    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
    
    
}
