package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conn {
	
	/**
	* Permet l'execution de requête sans réponse.<br/>
	* Liaison avec la base de donnée.
	*
	* @param requete  La requete qui sera executer dans la base de donne.
	* 
	* @return Ne renvois rien
	*/
	public void requeteSansReponse(String requete, ArrayList<String[]> Parametres) {
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/fripouille?" +
                                           "user=root&password=root");
            
            PreparedStatement preparedStatement = conn.prepareStatement(requete);
            Parametres.forEach(parametre -> {
            	System.out.println(Parametres.get(0));
            	System.out.println(Parametres.get(1));
            });
            
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(requete);
            conn.close();
        } catch (SQLException ex) {
        	
        }
		
	}
	
	/**
	* Permet l'execution de la requête select.<br/>
	* Liaison avec la base de donnée.
	*
	* @param requete  La requete qui sera executer dans la base de donne.
	* @param nombreColonne Le nombre de colonne qu'ai composez la réponse de la requete.
	* 
	* @return <code>List</code> Renvoie la réponse de la requête sous forme de liste de type string.
	*/
	public  List<String> select(String requete, int nombreColonne, List<Double> Parametres) {
		List<String> resultat = new ArrayList<String>();
		
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/fripouille?" +
                                           "user=root&password=root");
            
            PreparedStatement preparedStatement = conn.prepareStatement(requete);
            Parametres.forEach(parametre -> {
            	try {
					preparedStatement.setDouble(1, parametre);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
            
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(requete);
            while(resultSet.next()) {
            	String tempResultat = "";
            	for (int i = 1; i <= nombreColonne; i++) {
    				String tempVariable = resultSet.getString(i);
    				if(tempVariable != null) {
    					tempResultat += tempVariable+";";
    				}
    				
    			}
            	resultat.add(tempResultat);
            }
            conn.close();
        } catch (SQLException ex) {
        	
        }
		
		return resultat;
    	
    }
}