package com.theophas.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TuyauRouge extends Objet {
    private Image imgTuyauRouge;
    private ImageIcon icoTuyauRouge;


    public TuyauRouge(int x, int y){
        super(x, y, 43, 65);
        this.icoTuyauRouge = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        this.imgTuyauRouge = this.icoTuyauRouge.getImage();

    }


    public Image getImgTuyauRouge() {
        return imgTuyauRouge;
    }


    

    
}
