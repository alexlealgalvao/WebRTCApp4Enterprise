package io.antmedia.enterprise.webrtcapp;

import javax.websocket.server.ServerEndpoint;

import org.apache.tomcat.websocket.server.DefaultServerEndpointConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import io.antmedia.enterprise.webrtc.WebSocketEnterpriseHandler;


@ServerEndpoint(value="/websocket", configurator=DefaultServerEndpointConfigurator.class)
public class WebSocketLocalHandler extends WebSocketEnterpriseHandler {
	
	
	private ApplicationContext appCtx; 
	
	protected static Logger logger = LoggerFactory.getLogger(WebSocketLocalHandler.class);

	@Override
	public ApplicationContext getAppContext() {
		if (appCtx == null) {
			WebRTCSampleApplication application = WebRTCSampleApplication.getApplication();
			if (application != null) {
				appCtx = application.getContext().getApplicationContext();
			}
		}
		return appCtx;
	}
	

}
