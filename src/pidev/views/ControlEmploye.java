package pidev.views;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import pidev.entity.Utilisateur;
import pidev.services.GestionEmployerService;



public class ControlEmploye {

	public boolean ControleEmail(Utilisateur u) {
		// regex expression to verify if the mail inserted follow how emails should be
		// written
		if ((u.getEmail()).matches(
				"^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
			return true;
		}
		return false;
	}

	public boolean ControleCIN(Utilisateur u) {
		// regex expression to verify if the cin inserted contains only 8 numbers
		if ((u.getCin()).matches("[0-9]{8}")) {
			return true;
		}
		return false;
	}

	public boolean ControleTELNUMBER(Utilisateur u) {
		// regex expression to verify if the cin inserted contains only 8 numbers
		if ((u.getTelephone()).matches("[0-9]{8}")) {
			return true;
		}
		return false;
	}

	public static boolean ControleDate(Utilisateur u) {

		if (u.getDatenaissance() == null)
			return false;
		return true;
	}

	public static boolean ControleNOM(Utilisateur u) {
		String str = (u.getUsername()).toLowerCase();
                if (str.length() == 0)
                    return false;
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}
        
        	public static boolean ControleROLE(Utilisateur u) {
		String str = (u.getMission()).toLowerCase();
                if (str.length() == 0)
                    return false;
		return true;
	}

	public static boolean ControlePRENOM(Utilisateur u) {
		String str = (u.getPrenom()).toLowerCase();
                if (str.length() == 0)
                    return false;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}

	public static boolean ControleADRESSE(Utilisateur u) {
		String str = (u.getAdresse()).toLowerCase();
                if (str.length() == 0)
                    return false;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}

	public boolean verif(Utilisateur e) {
		if (e.getAdresse() == null && e.getCin() == null && e.getDatenaissance() == null && e.getEmail() == null
				&& e.getUsername() == null && e.getPrenom() == null)
			return true;
		else
			return false;
	}

	public String AjouterEmploye(Utilisateur u) {
		String retourstr = "";
		if ((verif(getUnEmployeCIN(u)))) {

			if (GestionEmployerService.AjoutUnEmploye(u) == 0)
				retourstr += "Une erreur est survenue ! ";

		} else
			retourstr += "Employé existant. ";

		return retourstr;
	}

	public Utilisateur getUnEmployeCIN(Utilisateur u) {
		if (ControleCIN(u)) {
			return GestionEmployerService.getUnEmployeCIN(u);
		}
		return null;
	}

	public List getUnEmployenom(Utilisateur u) {
		if (ControleNOM(u)) {
			return GestionEmployerService.getUnEmployeNom(u);
		}
		return null;
	}
        
        public double getNbrOuvrier() throws SQLException {
	        return Double.valueOf(GestionEmployerService.getNbrOuvrier());
	}
        
        public double getNbrIngenieur() throws SQLException {
	    return Double.valueOf(GestionEmployerService.getNbrIngenieur());
	}
        
        public double getNbrLivreur() throws SQLException {
	    return Double.valueOf(GestionEmployerService.getNbrLivreur());
	}
        
        public double getNbrTechnicien() throws SQLException {
	    return Double.valueOf(GestionEmployerService.getNbrTechnicien());
	}
        
        public int getMoyenneAge() {
            List<Utilisateur> liste =AfficheToutEmploye();
            int moyenne = 0;
            int dateactuel = LocalDate.now().getYear();
            for (Utilisateur u:liste){
                moyenne=moyenne+(dateactuel-(u.getDatenaissance().toLocalDate().getYear()));  
        }
            return moyenne;
        }

	public String ModificationUnEmploye(Utilisateur u) {
            String retourstr = "";
            Utilisateur user = getUnEmployeCIN(u);
            if (!verif(user)) {
                u.setId(user.getId());
                if (GestionEmployerService.ModificationUnEmploye(u) == 0)
                    retourstr += "Une erreur est survenue ! ";
            }    

		return retourstr;

	}

	public boolean SupprimerUnEmploye(Utilisateur u) {
	
			return GestionEmployerService.SupprimerUnEmploye(u);

	}

	public List AfficheToutEmploye() {
		List liste = GestionEmployerService.AfficheToutEmploye();
		return liste;
	}

	public boolean SupprimerToutEmploye() {
		return GestionEmployerService.SupprimerToutEmploye();
	}
}