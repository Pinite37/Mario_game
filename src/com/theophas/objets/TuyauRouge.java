package com.theophas.objets;



import javax.swing.ImageIcon;

public class TuyauRouge extends Objet {
    
    


    public TuyauRouge(int x, int y){
        super(x, y, 43, 65);
        super.icoObjet  = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        super.imgObjet = this.icoObjet.getImage();

    }


    


    

    
}
