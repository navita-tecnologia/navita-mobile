package br.com.navita.mobile.console.listener;

import java.util.TimerTask;
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
		//
		
		for(String token: SessionPool.keySet()){
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
