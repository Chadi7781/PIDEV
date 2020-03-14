
package pidev.services;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import pidev.entity.Produit;
import static pidev.services.GestionEmployerService.conx;
import static pidev.services.GestionEmployerService.rs;
import static pidev.services.GestionEmployerService.stmt;
import pidev.utils.css.ConnexionBD;
import pidev.utils.css.Utility;


public class GestionProduitService {

	public static List<Produit> AfficheToutProduit() {
		try {
			conx = ConnexionBD.getInstance().getConnection();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameProduit + "");
			List<Produit> liste = new LinkedList<Produit>();
			while (rs.next()) {
                            Produit produit = new Produit();
				produit.setCategorie(rs.getInt(Utility.CATEGORIE));
				produit.setDescription(rs.getString(Utility.DESCRIPTION));
				produit.setEtat(rs.getString(Utility.ETAT));
				produit.setId_depot(rs.getInt(Utility.ID_DEPOT));
				produit.setNom_pd(rs.getString(Utility.nom_produit));
				produit.setPhoto(rs.getString(Utility.PHOTO_PRODUIT));
				produit.setPoids(rs.getInt(Utility.POIDS));
				produit.setPrix(rs.getInt(Utility.PRIX));
				produit.setId_pro(rs.getInt(Utility.ID_PRODUIT));
				liste.add(produit);
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}

        	public static List<Produit> AfficheToutProduitParLIB(Produit p) {
		try {
			conx = ConnexionBD.getInstance().getConnection();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameProduit +" WHERE "+ Utility.nom_produit + " like '%" + p.getNom_pd() + "%'");
			List<Produit> liste = new LinkedList<Produit>();
			while (rs.next()) {
                            Produit produit = new Produit();
				produit.setCategorie(rs.getInt(Utility.CATEGORIE));
				produit.setDescription(rs.getString(Utility.DESCRIPTION));
				produit.setEtat(rs.getString(Utility.ETAT));
				produit.setId_depot(rs.getInt(Utility.ID_DEPOT));
				produit.setNom_pd(rs.getString(Utility.nom_produit));
				produit.setPhoto(rs.getString(Utility.PHOTO_PRODUIT));
				produit.setPoids(rs.getInt(Utility.POIDS));
				produit.setPrix(rs.getInt(Utility.PRIX));
				produit.setId_pro(rs.getInt(Utility.ID_PRODUIT));
				liste.add(produit);
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}

}
