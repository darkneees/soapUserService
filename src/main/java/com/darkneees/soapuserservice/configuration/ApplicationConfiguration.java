package com.darkneees.soapuserservice.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ApplicationConfiguration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/userService/*");
    }

    @Bean
    public XsdSchema userSchema(){
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("userServiceSoapHttp");
        wsdl11Definition.setLocationUri("/userService");
        wsdl11Definition.setTargetNamespace("http://users-soap/api/");
        wsdl11Definition.setSchema(userSchema);

        return wsdl11Definition;
    }
}
