package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Classe permettant de représenter un Navire de bataille navale
 *
 * 
 * @author léasilé
 * 
 * 
 */
public class Navire
{
	/**
	 * Taille du bateau
	 */
	protected int taille;
	/**
	 * l'état du bateau (mort ou vivant)
	 */
	protected boolean etat;
	/**
	 * nombre de fois où il peut être touché
	 */
	protected int pv;
	
/**
 * constructeur d'un Navire
 * initialisé a "vivant" avec tous ses PVs.
 * 
 * @param taill
 * 			taille du bateau
 */
	public Navire(int taill)
	{
		this.taille=taill;
		this.etat=true;
		this.pv=taill;
	}
	
	public boolean estTouche()
	{
		this.pv=this.pv-1;
		if (this.pv==0)
			this.etat=false;
		return etat;
		
	}

}
