package br.com.navita.mobile.console.listener;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.mw.jco.JCO;

import br.com.navita.mobile.console.sap.PoolManager;
import br.com.navita.mobile.console.sap.SapSession;

public class SapTimeoutScheduler extends TimerTask {
	private static final Logger LOG = Logger.getLogger(SapTimeoutScheduler.class.getName());
	private static final long UM_SEGUNDO = 1000L;
	private static final long UM_MINUTO = 60L * UM_SEGUNDO;
	private static final long QUINZE_MINUTOS = 15L * UM_MINUTO;

	@Override
	public void run() {
		LOG.log(Level.INFO,"Timeout scheduler fired");
		
		for(String token: PoolManager.REPOSITORY_POOL.keySet()){
			SapSession session = PoolManager.REPOSITORY_POOL.get(token);
			LOG.log(Level.INFO,"Timeout scheduler checking "+token);
			if(System.currentTimeMillis() - session.getTimestamp() > QUINZE_MINUTOS){
				LOG.log(Level.WARNING,"Removendo sessao SAP por timeout token = "+token);
				JCO.removeClientPool(token);
				PoolManager.REPOSITORY_POOL.remove(token);
			}else{
				LOG.log(Level.INFO,"Timeout for token "+token+" not reached");
			}
		}

	}

}
