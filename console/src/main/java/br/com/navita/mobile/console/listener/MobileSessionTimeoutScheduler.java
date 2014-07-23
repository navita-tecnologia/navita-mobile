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
package br.com.navita.mobile.console.listener;

import java.util.Set;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.session.MobileSession;
import br.com.navita.mobile.console.session.SessionPool;

public class MobileSessionTimeoutScheduler extends TimerTask {
	
	private static final Logger LOG = Logger.getLogger(MobileSessionTimeoutScheduler.class.getName());	

	public MobileSessionTimeoutScheduler() {
		LOG.log(Level.INFO,"Timeout scheduler started");
	}
	
	@Override
	public void run() {
		Set<String> tokens = new TreeSet<String>(SessionPool.keySet());
		for(String token: tokens){
			MobileSession session =  SessionPool.get(token);
			LOG.log(Level.INFO,"Timeout scheduler checking "+token);
			if(System.currentTimeMillis() - session.getTimeStamp() > session.getTimeout()){
				LOG.log(Level.WARNING,"Removendo sessao por timeout token = "+token);
				session.release();
				SessionPool.remove(token);
			}else{
				LOG.log(Level.INFO,"Timeout for token "+token+" not reached");
			}
		}
	}

}
