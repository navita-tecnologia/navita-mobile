
package br.com.navita.mobile.push.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.navita.mobile.push.ws.client package. 
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

    private final static QName _ExecuteResponse_QNAME = new QName("http://push.console.mobile.navita.com.br/", "executeResponse");
    private final static QName _PushException_QNAME = new QName("http://push.console.mobile.navita.com.br/", "PushException");
    private final static QName _Execute_QNAME = new QName("http://push.console.mobile.navita.com.br/", "execute");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.navita.mobile.push.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PushBean }
     * 
     */
    public PushBean createPushBean() {
        return new PushBean();
    }

    /**
     * Create an instance of {@link ExecuteResponse }
     * 
     */
    public ExecuteResponse createExecuteResponse() {
        return new ExecuteResponse();
    }

    /**
     * Create an instance of {@link PushResult }
     * 
     */
    public PushResult createPushResult() {
        return new PushResult();
    }

    /**
     * Create an instance of {@link Execute }
     * 
     */
    public Execute createExecute() {
        return new Execute();
    }

    /**
     * Create an instance of {@link PushException }
     * 
     */
    public PushException createPushException() {
        return new PushException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://push.console.mobile.navita.com.br/", name = "executeResponse")
    public JAXBElement<ExecuteResponse> createExecuteResponse(ExecuteResponse value) {
        return new JAXBElement<ExecuteResponse>(_ExecuteResponse_QNAME, ExecuteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PushException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://push.console.mobile.navita.com.br/", name = "PushException")
    public JAXBElement<PushException> createPushException(PushException value) {
        return new JAXBElement<PushException>(_PushException_QNAME, PushException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Execute }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://push.console.mobile.navita.com.br/", name = "execute")
    public JAXBElement<Execute> createExecute(Execute value) {
        return new JAXBElement<Execute>(_Execute_QNAME, Execute.class, null, value);
    }

}
