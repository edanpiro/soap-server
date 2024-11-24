package pe.idat.servidorws;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;
import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.idat.servidorws.impl.PersonServiceImpl;

@Configuration
public class ApplicationConfig {

  @Autowired
  private Bus bus;

  @Bean
  public Endpoint endpoint(PersonServiceImpl personServiceImpl){
    Endpoint endpoint = new EndpointImpl(bus, personServiceImpl, SOAPBinding.SOAP12HTTP_BINDING);
    endpoint.publish("/soap/Service");
    return endpoint;
  }
}
