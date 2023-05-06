
package com.cts.soap.ws;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cts.soap.ws package. 
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

    private final static QName _CalculatePrice_QNAME = new QName("http://ws.soap.cts.com/", "calculatePrice");
    private final static QName _CalculatePriceResponse_QNAME = new QName("http://ws.soap.cts.com/", "calculatePriceResponse");
    private final static QName _Ticket_QNAME = new QName("http://ws.soap.cts.com/", "ticket");
    private final static QName _InvalidTicketDetailsException_QNAME = new QName("http://ws.soap.cts.com/", "InvalidTicketDetailsException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cts.soap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculatePrice }
     * 
     */
    public CalculatePrice createCalculatePrice() {
        return new CalculatePrice();
    }

    /**
     * Create an instance of {@link CalculatePriceResponse }
     * 
     */
    public CalculatePriceResponse createCalculatePriceResponse() {
        return new CalculatePriceResponse();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link InvalidTicketDetailsException }
     * 
     */
    public InvalidTicketDetailsException createInvalidTicketDetailsException() {
        return new InvalidTicketDetailsException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePrice }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculatePrice }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.cts.com/", name = "calculatePrice")
    public JAXBElement<CalculatePrice> createCalculatePrice(CalculatePrice value) {
        return new JAXBElement<CalculatePrice>(_CalculatePrice_QNAME, CalculatePrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePriceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculatePriceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.cts.com/", name = "calculatePriceResponse")
    public JAXBElement<CalculatePriceResponse> createCalculatePriceResponse(CalculatePriceResponse value) {
        return new JAXBElement<CalculatePriceResponse>(_CalculatePriceResponse_QNAME, CalculatePriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.cts.com/", name = "ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidTicketDetailsException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidTicketDetailsException }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.cts.com/", name = "InvalidTicketDetailsException")
    public JAXBElement<InvalidTicketDetailsException> createInvalidTicketDetailsException(InvalidTicketDetailsException value) {
        return new JAXBElement<InvalidTicketDetailsException>(_InvalidTicketDetailsException_QNAME, InvalidTicketDetailsException.class, null, value);
    }

}
