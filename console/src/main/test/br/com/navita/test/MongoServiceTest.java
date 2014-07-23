/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
