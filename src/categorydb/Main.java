package categorydb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import categorydb.sql.OLSQLQueries;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException{
		try {
			OLSQLQueries queryMachine = new OLSQLQueries("localhost", "SmartSantander", "root", "onizukalab");
			BufferedReader br = new BufferedReader(new FileReader("storeID.txt"));
			String s;
			while((s = br.readLine()) != null){
				if(!s.contains("spanish")){
					queryMachine.updateCategoryID(s.split("\t"));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

