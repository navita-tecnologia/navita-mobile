
package br.com.navita.mobile.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "singlePoint", targetNamespace = "http://ws.mobile.navita.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SinglePoint {


    /**
     * 
     * @param arg0
     * @return
     *     returns br.com.navita.mobile.ws.client.GenericBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "execute", targetNamespace = "http://ws.mobile.navita.com.br/", className = "br.com.navita.mobile.ws.client.Execute")
    @ResponseWrapper(localName = "executeResponse", targetNamespace = "http://ws.mobile.navita.com.br/", className = "br.com.navita.mobile.ws.client.ExecuteResponse")
    public GenericBean execute(
        @WebParam(name = "arg0", targetNamespace = "")
        GenericBean arg0);

}
