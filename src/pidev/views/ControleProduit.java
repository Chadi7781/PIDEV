
package pidev.views;


import java.util.List;
import pidev.entity.Produit;
import pidev.services.GestionProduitService;


public class ControleProduit {
    	public static boolean ControleNOM(Produit u) {
		String str = (u.getNom_pd()).toLowerCase();
                if (str.length() == 0)
                    return false;
		return true;
	}
	List<Produit> AfficheToutProduit() {
		return GestionProduitService.AfficheToutProduit();
	}
        
        List<Produit> AfficheToutProduitParLIB(Produit p) {
		return GestionProduitService.AfficheToutProduitParLIB(p);
	}
                

	public static void main(String[] a) {
		ControleProduit controleProduit = new ControleProduit();
		List<Produit> list = controleProduit.AfficheToutProduit();
		for (int i = 0; i < list.size(); i++) {
			System.out.println((list.get(i)).getDescription());
		}
	}
        


}
