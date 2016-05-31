package com.example;

import com.liferay.bnd.test.api.ExampleProviderInterface;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=test-portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestPortlet extends MVCPortlet {
	
	private ExampleProviderInterface _provider;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ExampleProviderInterface provider = getExampleProviderInterface();
		
		String foo = provider.provide("foo");
		
		renderRequest.setAttribute("foo", foo);
		
		super.doView(renderRequest, renderResponse);
	}
	
	private ExampleProviderInterface getExampleProviderInterface() {
		return _provider;
	}

	@Reference
	public void setExampleProviderInterface(ExampleProviderInterface provider) {
		_provider = provider;
	}
	
}