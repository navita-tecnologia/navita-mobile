package br.com.navita.test;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Mongo mongo3 = new Mongo(  "pin.navita.com.br", 27017  );
		//System.out.println(mongo3.getVersion());
		DB db =  mongo3.getDB("SportsDataBase");
		boolean auth = db.authenticate("admin", "nvtsports".toCharArray());
		if(! auth){
			System.out.println("Authentication failed");
			return;
		}
//		Set<String> colls = db.getCollectionNames();
//		for (String s : colls) {
//		    System.out.println(s);
//		}
	 DBCollection collection = db.getCollection("SoccerMatch");
	 //System.out.println(collection.findOne());
	 BasicDBObject query = new BasicDBObject();
     query.put("tournamentName", "South America: Copa América");
     query.put("date", new BasicDBObject("$gt", getDate("13/07/2011")) );
     DBCursor cur = collection.find(query);
     while(cur.hasNext()) {
         System.out.println(cur.next().get("date"));
     }
	}

	private static Date getDate(String date) throws ParseException {
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy", new Locale("PT", "BR"));
		return dtf.parse(date);
	}

}
