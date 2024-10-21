package pe.idat.servidorws.impl;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.servidorws.entity.Persona;
import pe.idat.servidorws.repository.PersonaRepository;
import pe.idat.sumservice.schema.GetPersonaRequest;
import pe.idat.sumservice.schema.GetPersonaResponse;
import pe.idat.sumservice.schema.GetSumRequest;
import pe.idat.sumservice.schema.GetSumResponse;
import pe.idat.sumservice.wsdl.SumServicePort;

import java.util.Optional;

@Service
@SchemaValidation(type = SchemaValidationType.REQUEST)
// @InInterceptors(classes = WSSecurityInterceptor.class)
public class SumServiceImpl implements SumServicePort {

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public GetSumResponse getSum(GetSumRequest parameters) {
    GetSumResponse response = new GetSumResponse();
    response.setResult(parameters.getAddendOne() + parameters.getAddendTwo());
    return response;
  }

  @Override
  public GetPersonaResponse getPersona(GetPersonaRequest request) {
    GetPersonaResponse response = new GetPersonaResponse();
    Long id = (long) request.getId();
    System.out.println("ID solicitado: " + id);
    Optional<Persona> personaOpt = personaRepository.findById(id);
    if (personaOpt.isPresent()) {
      Persona persona = personaOpt.get();
      System.out.println("Persona encontrada: " + persona);
      response.setNombre(persona.getNombre());
    } else {
      System.out.println("No se encontró persona con ID: " + id);
      response.setNombre("No existe persona con id " + id);
    }
    return response;
  }
}