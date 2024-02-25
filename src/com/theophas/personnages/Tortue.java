package com.theophas.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.theophas.objets.Objet;

public class Tortue extends Personnage implements Runnable{

	private Image imgTortue;
	private ImageIcon icoTortue;
	
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxTortue; // pas de d�placement de la tortue
	
	//**** CONSTRUCTEUR	****//
	public Tortue(int x, int y) {
			
		super(x, y, 43, 50);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxTortue = 1;
			
		this.icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
		this.imgTortue = this.icoTortue.getImage();
			
		Thread chronoChamp = new Thread(this);
		chronoChamp.start();
		}
	//**** GETTERS ****//		
	public Image getImgTortue() {return imgTortue;}

			
	//**** SETTERS ****//
			
			
	//**** METHODES ****//	
	public void bouge(){ // D�placement de la tortue
	    if(super.isVersDroite() == true){this.dxTortue = 1;}
	    else{this.dxTortue = -1;}
	    super.setX(super.getX() + this.dxTortue);  	
	}
	
	@Override
	public void run() {
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient compl�tement cr��s
		catch (InterruptedException e){}		
		
		while(true){ // boucle infinie											
		    this.bouge();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}
	}
	

	public void contact(Objet objet) {			
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
	    	this.dxTortue = -1; 
	    }else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxTortue = 1;     
	    }	
	}
	
	
}
