package com.alibaba.webx.restful.bvt;

import junit.framework.Assert;

import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.alibaba.webx.restful.examples.helloworld.HelloworldTestBase;

public class HelloworldTest extends HelloworldTestBase {

    public void test_hello() throws Exception {

        Assert.assertNotNull(component);

        MockHttpServletRequest request = new MockHttpServletRequest(servletContext);
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setServletPath("/rest");
        request.setContextPath("/study");
        request.setRequestURI("/study/rest/helloworld/now");
        request.setServerPort(8080);
        request.setServerName("localhost");

        MockFilterChain chain = new MockFilterChain();

        filter.doFilter(request, response, chain);
        
        String content = response.getContentAsString();
        System.out.println(content);
    }
}
