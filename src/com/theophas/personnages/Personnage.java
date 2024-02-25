package com.theophas.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.theophas.jeu.Main;
import com.theophas.objets.Objet;

public class Personnage {

    // **** VARIABLES ****//
    private int largeur, hauteur; // dimensions du personnage
    private int x, y; // position du personnage
    protected boolean marche; // vrai quand le personnage marche
    protected boolean versDroite; // vrai quand le personnage est tourn� vers la droite
    public int compteur; // compteur des pas du personnage

    // **** CONSTRUCTEUR ****//
    public Personnage(int x, int y, int largeur, int hauteur) {

        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }

    // **** GETTERS ****//
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public boolean isMarche() {
        return marche;
    }

    public boolean isVersDroite() {
        return versDroite;
    }

    public int getCompteur() {
        return compteur;
    }

    // **** SETTERS ****//
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMarche(boolean marche) {
        this.marche = marche;
    }

    public void setVersDroite(boolean versDroite) {
        this.versDroite = versDroite;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    // **** METHODES ****//
    public Image marche(String nom, int frequence) {

        String str;
        ImageIcon ico;
        Image img;

        if (this.marche == false) {
            if (this.versDroite == true) {
                str = "/images/" + nom + "ArretDroite.png";
            } else {
                str = "/images/" + nom + "ArretGauche.png";
            }
        } else {
            this.compteur++;
            if (this.compteur / frequence == 0) {
                if (this.versDroite == true) {
                    str = "/images/" + nom + "ArretDroite.png";
                } else {
                    str = "/images/" + nom + "ArretGauche.png";
                }
            } else {
                if (this.versDroite == true) {
                    str = "/images/" + nom + "MarcheDroite.png";
                } else {
                    str = "/images/" + nom + "MarcheGauche.png";
                }
            }
            if (this.compteur == 2 * frequence) {
                this.compteur = 0;
            }
        }
        // Affichage de l'image du personnage
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void deplacement(){
        if(Main.scene.getxPos() >= 0){
            this.x = this.x - Main.scene.getDx();
        }
    }
    

    protected boolean contactAvant(Objet objet){
	    if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 ||
	       this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
		else{return true;}
	} 
    
    // D�tection contact � gauche de Mario
    protected boolean contactArriere(Objet objet){		
		if(this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 || 
		   this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
		else{return true;}
	}

    // D�tection contact en dessous de Mario
    protected boolean contactDessous(Objet objet){		
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || 
		   this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5){return false;}
		else{return true;}		
	}

    // D�tection contact au-dessus de Mario
    protected boolean contactDessus(Objet objet){
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || 
		   this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5){return false;}
		else{return true;}
	}   
    
    public boolean proche(Objet objet){  	
    	if((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10) 
    	|| (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)){return true;}
    	else{return false;}
    }
}
