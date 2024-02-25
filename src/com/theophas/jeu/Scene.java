package com.theophas.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.theophas.objets.Bloc;
import com.theophas.objets.Objet;
import com.theophas.objets.Piece;
import com.theophas.objets.TuyauRouge;
import com.theophas.personnages.Champ;
import com.theophas.personnages.Mario;
import com.theophas.personnages.Tortue;


//***** La classe Scene est le classe la plus importante de l'application. *****//
//***** Elle est accessible par toutes les autres classes, contient le "moteur" de l'application *****//
//***** Elle g�re la partie graphique. *****//
@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	
	//**** VARIABLES **//
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;  
	private Image imgChateau1;  
	private ImageIcon icoDepart;  
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;   // d�placement du fond d'�cran.
	private int xPos; // position absolue dans le jeu
	private int ySol; // hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	
	public Mario mario;
	
	public Champ champ;
	public Tortue tortue;
	
	public TuyauRouge tuyauRouge1;
	public TuyauRouge tuyauRouge2;
	public TuyauRouge tuyauRouge3;
	public TuyauRouge tuyauRouge4;
	public TuyauRouge tuyauRouge5;
	public TuyauRouge tuyauRouge6;
	public TuyauRouge tuyauRouge7;
	public TuyauRouge tuyauRouge8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	private ArrayList<Objet> tabObjets; // tableau qui enregistre tous les objets du jeu
	private ArrayList<Piece> tabPieces; // tableau qui enregistre toutes les pi�ces du jeu
	
	//**** CONSTRUCTEUR ****//	
	public Scene(){
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png")); 
		this.imgChateau1 = this.icoChateau1.getImage();  
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		mario = new Mario(300, 245);
		champ = new Champ(800, 263);
		tortue = new Tortue(950, 243);
		
		tuyauRouge1 = new TuyauRouge(600, 230);
		tuyauRouge2 = new TuyauRouge(1000, 230);
		tuyauRouge3 = new TuyauRouge(1600, 230);
		tuyauRouge4 = new TuyauRouge(1900, 230);
		tuyauRouge5 = new TuyauRouge(2500, 230);
		tuyauRouge6 = new TuyauRouge(3000, 230);
		tuyauRouge7 = new TuyauRouge(3800, 230);
		tuyauRouge8 = new TuyauRouge(4500, 230);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3550, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		piece1 = new Piece(402, 145);
		piece2 = new Piece(1202, 140);
		piece3 = new Piece(1272, 95);
		piece4 = new Piece(1342, 40);
		piece5 = new Piece(1650, 145);
		piece6 = new Piece(2650, 145);
		piece7 = new Piece(3000, 135);
		piece8 = new Piece(3400, 125);
		piece9 = new Piece(4200, 145);
		piece10 = new Piece(4600, 40);
		
		this.icoChateauFin = new ImageIcon(getClass().getResource("/images/chateauFin.png")); 
		this.imgChateauFin = this.icoChateauFin.getImage(); 
		
		this.icoDrapeau = new ImageIcon(getClass().getResource("/images/drapeau.png")); 
		this.imgDrapeau = this.icoDrapeau.getImage(); 
		
		tabObjets = new ArrayList<Objet>();	
		
		this.tabObjets.add(this.tuyauRouge1);
		this.tabObjets.add(this.tuyauRouge2);
		this.tabObjets.add(this.tuyauRouge3);
		this.tabObjets.add(this.tuyauRouge4);
		this.tabObjets.add(this.tuyauRouge5);
		this.tabObjets.add(this.tuyauRouge6);
		this.tabObjets.add(this.tuyauRouge7);
		this.tabObjets.add(this.tuyauRouge8);
		
		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
			
		tabPieces = new ArrayList<Piece>();			
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHautPlafond(){return hauteurPlafond;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}


	//**** METHODES ****//
	public void deplacementFond(){ // D�placement des images "fixes" de l'�cran simulant le d�placement de mario 

		if(this.xPos >= 0 && this.xPos <= 4430){
			// Mise � jour des positions des �l�ments du jeu lors du d�placement de mario
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		// Permanence du fond d'�cran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}


	public void paintComponent(Graphics g) { // Dessin de toutes les images visibles � l'�cran (appel toutes les 3 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;

		// D�tections des contacts avec des objets
		for(int i = 0; i < this.tabObjets.size(); i++){
		    // mario
		    if(this.mario.proche(this.tabObjets.get(i))){this.mario.contact(this.tabObjets.get(i));}
		    if(this.champ.proche(this.tabObjets.get(i))){this.champ.contact(this.tabObjets.get(i));}
		    if(this.tortue.proche(this.tabObjets.get(i))){this.tortue.contact(this.tabObjets.get(i));}
		}
		
    	// D�tection des contacts de mario avec des pi�ces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 		if(this.mario.proche(this.tabPieces.get(i))){
 	 			if(this.mario.contactPiece(this.tabPieces.get(i))){
 	 				this.tabPieces.remove(i);
 	 			}
 	 	    }
 	 	}
		
 	 	if(this.champ.proche(tortue)){this.champ.contact(tortue);}
 	 	if(this.tortue.proche(champ)){this.tortue.contact(champ);}
 	 	
		// D�placement de tous les objets "fixes" du jeu		
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos <= 4430){
		    for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}
		    for(int i = 0; i < this.tabPieces.size(); i++){this.tabPieces.get(i).deplacement();}
		    this.champ.deplacement();
		    this.tortue.deplacement();
		}
		
		// Image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		
		// Image du ch�teau du d�part
 		g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null);
    	// Image du panneau de d�part
 		g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null);

     	// Images des objets
 	 	for(int i = 0; i < this.tabObjets.size(); i++){
 	 		g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
 	 	}	
 	 	 
 	 	// Images des pi�ces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 		g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
 	 	}
 	 	
 	    // Image du drapeau d'arriv�e
 	 	g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
 	    // Image du ch�teau d'arriv�e
 		g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
 	 	
        // Image de mario
 		if(this.mario.isSaut()){g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);}
 		else{g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);}	
 		
 		// Image du champignon
 		g2.drawImage(this.champ.marche("champ", 45), this.champ.getX(), this.champ.getY(), null);

 		// Image de la tortue
 		g2.drawImage(this.tortue.marche("tortue", 45), this.tortue.getX(), this.tortue.getY(), null);
	}
}