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
package br.com.navita.mobile.console.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Fabio
 *
 */
public class NavitaAutowiringSupport {

	private static final Logger logger = Logger.getLogger(NavitaAutowiringSupport.class.getName());

	@Resource
	protected WebServiceContext context;

	/**
	 * This method performs injection on this instance,
	 * based on the current web application context.
	 * <p>Intended for use as a base class.
	 * @see #processInjectionBasedOnCurrentContext
	 */
	@PostConstruct
	public void initialize() {
		processInjectionBasedOnCurrentContext();
	}

	/**
	 * Process <code>@Autowired</code> injection for the given target object,
	 * based on the current web application context.
	 * <p>Intended for use as a delegate.
	 * @param target the target object to process
	 * @see org.springframework.web.context.ContextLoader#getCurrentWebApplicationContext()
	 */
	protected void processInjectionBasedOnCurrentContext() {
		Assert.notNull(this, "Target object must not be null");
		WebApplicationContext appCtx = getApplicationContext();
		if (appCtx != null) {
			processInjection(appCtx);
		}
		else {
			if (logger.isLoggable(Level.FINER)) {
				logger.finer("Current WebApplicationContext is not available for processing of " +
						ClassUtils.getShortName(this.getClass()) + ": " +
						"Make sure this class gets constructed in a Spring web application. Proceeding without injection.");
			}
		}
	}

	/**
	 * @param appCtx
	 * @param target
	 */
	protected void processInjection(WebApplicationContext appCtx) {
		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
		bpp.setBeanFactory(appCtx.getAutowireCapableBeanFactory());
		bpp.processInjection(this);
	}

	/**
	 * @return
	 */
	protected WebApplicationContext getApplicationContext() {
		WebApplicationContext appCtx = ContextLoader.getCurrentWebApplicationContext();
		if (appCtx == null) {
			//Weblogic specific
			Thread thread = Thread.currentThread();
			ClassLoader wsLoader = thread.getContextClassLoader();
			thread.setContextClassLoader(wsLoader.getParent());
			appCtx = ContextLoader.getCurrentWebApplicationContext();
			thread.setContextClassLoader(wsLoader);
		}
		return appCtx;
	}
}
