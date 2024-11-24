package pe.idat.servidorws.impl;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.servidorws.entity.Persona;
import pe.idat.servidorws.repository.PersonaRepository;
import pe.idat.service.schema.*;
import pe.idat.service.wsdl.SoapServicePort;

import java.util.Optional;

@Service
@SchemaValidation(type = SchemaValidationType.REQUEST)
// @InInterceptors(classes = WSSecurityInterceptor.class)
public class PersonServiceImpl implements SoapServicePort {
//public class SumServiceImpl {

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public GetPersonaResponse getPersona(GetPersonaRequest request) {
    GetPersonaResponse response = new GetPersonaResponse();
    Long id = (long) request.getId();
    System.out.println("ID solicitado: " + id);
    Optional<Persona> personaOpt = personaRepository.findById(id);
    if (personaOpt.isPresent()) {
      Persona persona = personaOpt.get();
      System.out.println("Persona encontrada: " + persona);
      response.setId(persona.getId().intValue());
      response.setNombre(persona.getNombre());
      response.setApellido(persona.getApellido());
      response.setEdad(persona.getEdad());
    } else {
      System.out.println("No se encontró persona con ID: " + id);
      response.setNombre("No existe persona con id " + id);
    }
    return response;
  }

  @Override
  public AddPersonResponse addPerson(AddPersonRequest request) {
    AddPersonResponse response = new AddPersonResponse();
    Persona persona = new Persona();
    persona.setNombre(request.getNombre());
    persona.setApellido(request.getApellido());
    persona.setEdad(request.getEdad());
    personaRepository.save(persona);
    response.setStatus("Persona guardada");
    return response;
  }

  @Override
  public UpdatePersonResponse updatePerson(UpdatePersonRequest request) {
    UpdatePersonResponse response = new UpdatePersonResponse();
    Long id = (long) request.getId();
    Optional<Persona> personaOpt = personaRepository.findById(id);
    if (personaOpt.isPresent()) {
      Persona persona = personaOpt.get();
      persona.setEdad(request.getEdad());
      personaRepository.save(persona);
      response.setStatus("Edad actualizada");
    } else {
      response.setStatus("No se encontró persona con id " + id);
    }
    return response;
  }

  @Override
  public DeletePersonResponse deletePerson(DeletePersonRequest request) {
    DeletePersonResponse response = new DeletePersonResponse();
    Long id = (long) request.getId();
    Optional<Persona> personaOpt = personaRepository.findById(id);
    if (personaOpt.isPresent()) {
      personaRepository.deleteById(id);
      response.setStatus("Persona eliminada");
    } else {
      response.setStatus("No se encontró persona con id " + id);
    }
    return response;
  }
}