package com.theophas.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.theophas.objets.Bloc;
import com.theophas.objets.Objet;
import com.theophas.objets.TuyauRouge;
import com.theophas.personnages.Mario;

@SuppressWarnings("serial")
public class Scene extends JPanel {

	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;  
	private Image imgChateau1;  
	private ImageIcon icoDepart;  
	private Image imgDepart;
	
	
	
	private int xFond1;
	private int xFond2;
	private int dx;
	private int xPos;

	private int ySol;
	private int hauteurPlafond;


    public Mario mario;

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


	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;


	private ArrayList<Objet> tabObjets;
	
	
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
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {
        return dx;
    }
	
	public int getxPos() {
        return xPos;
    }


	


	public int getySol() {
		return ySol;
	}


	public int getHauteurPlafond() {
		return hauteurPlafond;
	}

	


	public void setHauteurPlafond(int hauteurPlafond) {
		this.hauteurPlafond = hauteurPlafond;
	}


	public void setySol(int ySol) {
		this.ySol = ySol;
	}


	//**** SETTERS ****//
	public void setDx(int dx) {
        this.dx = dx;
    }
	
	public void setxPos(int xPos) {
        this.xPos = xPos;
    }
		
	public void setxFond1(int xFond1) {
        this.xFond1 = xFond1;
    }

	public void setxFond2(int xFond2) {
        this.xFond2 = xFond2;
    }




	//**** METHODES ****//
	public void deplacementFond(){
		
		if(this.xPos >= 0 && this.xPos <= 4430){
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFond1 == -800){
            this.xFond1 = 800;
        }else if(this.xFond2 == -800){
            this.xFond2 = 800;
        }else if(this.xFond1 == 800){
            this.xFond1 = -800;
        }else if(this.xFond2 == 800){
            this.xFond2 = -800;
        }
	}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		
		for(int i = 0; i < this.tabObjets.size(); i++){
			if(this.mario.proche(this.tabObjets.get(i))){
				this.mario.contact(this.tabObjets.get(i));
			}
		}

		this.deplacementFond();

		if(this.xPos >= 0 && this.xPos <= 4430){
			for(int i = 0; i < this.tabObjets.size(); i++){
				this.tabObjets.get(i).deplacement();
			}
		}

		

		
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
 		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
 		g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
		
		for(int i = 0; i < this.tabObjets.size(); i++){
			g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
		}

		g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);

		g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
		if(this.mario.isSaut()){
			g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);
		}else{
			g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null); 
		}
	}
}
