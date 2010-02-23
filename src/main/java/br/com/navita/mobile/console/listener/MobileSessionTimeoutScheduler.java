package br.com.navita.mobile.console.listener;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.session.MobileSession;
import br.com.navita.mobile.console.session.SessionPool;

public class MobileSessionTimeoutScheduler extends TimerTask {
	
	private static final Logger LOG = Logger.getLogger(MobileSessionTimeoutScheduler.class.getName());	

	@Override
	public void run() {
		LOG.log(Level.INFO,"Timeout scheduler fired");
		
		for(String token: SessionPool.keySet()){
			MobileSession session =  SessionPool.get(token);
			LOG.log(Level.INFO,"Timeout scheduler checking "+token);
			if(System.currentTimeMillis() - session.getTimestamp() > session.getTimeout()){
				LOG.log(Level.WARNING,"Removendo sessao por timeout token = "+token);
				session.release();
			}else{
				LOG.log(Level.INFO,"Timeout for token "+token+" not reached");
			}
		}

	}

}
