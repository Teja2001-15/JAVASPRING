package com.example.communitysavings.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

    public static final String NAMESPACE = "http://example.com/communitysavings/ws";

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public XsdSchema communitySavingsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/community-savings.xsd"));
    }

    @Bean(name = "savings")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema communitySavingsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SavingsServicePort");
        wsdl11Definition.setLocationUri("/ws/savings");
        wsdl11Definition.setTargetNamespace(NAMESPACE);
        wsdl11Definition.setSchema(communitySavingsSchema);
        return wsdl11Definition;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.communitysavings.ws");
        return marshaller;
    }
}
