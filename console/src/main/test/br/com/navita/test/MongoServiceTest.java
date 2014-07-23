package br.com.navita.test;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoServiceTest {

	/**
	 * @param args
	 * @throws MongoException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, MongoException {
		MongoServiceTest testService = new MongoServiceTest();
		testService.test();
	}

	private void test() throws UnknownHostException, MongoException {
		DB mongoDb = getMongoDb();
		DBCollection collection = mongoDb.getCollection("SoccerMatch");
		BasicDBObject query = new BasicDBObject();
		query.put("_id", 231780);
		//query.put("date", new BasicDBObject("$gt", getDate("13/07/2011")) );
		DBCursor cur = collection.find(query);
		while(cur.hasNext()) {
			//System.out.println(cur.next().get("soccerMatchEventsList").getClass().getName());
			System.out.println(cur.next());
		}
	}

	private DB getMongoDb() throws UnknownHostException, MongoException {
		Mongo mongo = new Mongo( "pin.navita.com.br", 27017  );
		//System.out.println(mongo3.getVersion());
		DB db =  mongo.getDB("SportsDataBase");
		boolean auth = db.authenticate("admin", "nvtsports".toCharArray());
		if(! auth){
			System.out.println("Authentication failed");
			return null;
		}
		return db;
	}

//	private static Date getDate(String date) {
//		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy", new Locale("PT", "BR"));
//		try {
//			return dtf.parse(date);
//		} catch (ParseException e) {
//			return null;
//		}
//	}


}
