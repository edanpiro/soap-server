package pe.idat.sumservice.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2024-10-21T14:11:20.580-05:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://idat.pe/SumService/wsdl", name = "SumServicePort")
@XmlSeeAlso({pe.idat.sumservice.schema.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SumServicePort {

    @WebMethod(operationName = "GetSum", action = "http://idat.pe/SumService/GetSum")
    @WebResult(name = "GetSumResponse", targetNamespace = "http://idat.pe/SumService/schema", partName = "parameters")
    public pe.idat.sumservice.schema.GetSumResponse getSum(
        @WebParam(partName = "parameters", name = "GetSumRequest", targetNamespace = "http://idat.pe/SumService/schema")
        pe.idat.sumservice.schema.GetSumRequest parameters
    );

    @WebMethod(operationName = "GetPersona", action = "http://idat.pe/SumService/GetPersona")
    @WebResult(name = "GetPersonaResponse", targetNamespace = "http://idat.pe/SumService/schema", partName = "parameters")
    public pe.idat.sumservice.schema.GetPersonaResponse getPersona(
        @WebParam(partName = "parameters", name = "GetPersonaRequest", targetNamespace = "http://idat.pe/SumService/schema")
        pe.idat.sumservice.schema.GetPersonaRequest parameters
    );
}
