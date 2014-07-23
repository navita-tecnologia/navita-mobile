package br.com.navita.mobile.console.push;

import br.com.navita.mobile.console.exception.PushException;

public interface PushGatewayService {

	PushResult execute(PushBean pushBean) throws PushException;
}
