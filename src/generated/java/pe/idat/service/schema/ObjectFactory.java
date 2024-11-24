
package pe.idat.service.schema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.idat.service.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.idat.service.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonaRequest }
     * 
     */
    public GetPersonaRequest createGetPersonaRequest() {
        return new GetPersonaRequest();
    }

    /**
     * Create an instance of {@link GetPersonaResponse }
     * 
     */
    public GetPersonaResponse createGetPersonaResponse() {
        return new GetPersonaResponse();
    }

    /**
     * Create an instance of {@link AddPersonRequest }
     * 
     */
    public AddPersonRequest createAddPersonRequest() {
        return new AddPersonRequest();
    }

    /**
     * Create an instance of {@link AddPersonResponse }
     * 
     */
    public AddPersonResponse createAddPersonResponse() {
        return new AddPersonResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonRequest }
     * 
     */
    public UpdatePersonRequest createUpdatePersonRequest() {
        return new UpdatePersonRequest();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link DeletePersonRequest }
     * 
     */
    public DeletePersonRequest createDeletePersonRequest() {
        return new DeletePersonRequest();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

}
