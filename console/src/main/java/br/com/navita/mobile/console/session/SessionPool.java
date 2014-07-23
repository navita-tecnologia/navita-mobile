package br.com.navita.mobile.console.session;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessionPool {
	private static final Map<String, MobileSession> POOL = Collections.synchronizedMap( new HashMap<String, MobileSession>());

	public static MobileSession get(Object key) {
		return POOL.get(key);
	}

	public static MobileSession put(String key, MobileSession value) {
		return POOL.put(key, value);
	}

	public static Set<String> keySet() {
		return POOL.keySet();
	}

	public static MobileSession remove(Object key) {
		return POOL.remove(key);
	}
	
	
	
}
