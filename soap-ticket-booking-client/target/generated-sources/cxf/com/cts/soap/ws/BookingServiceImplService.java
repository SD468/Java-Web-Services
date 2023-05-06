package com.cts.soap.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.0
 * 2023-05-05T17:16:49.728+05:30
 * Generated source version: 4.0.0
 *
 */
@WebServiceClient(name = "BookingServiceImplService",
                  wsdlLocation = "http://localhost:8080/soap-ticket-booking-service/BookingService?wsdl",
                  targetNamespace = "http://ws.soap.cts.com/")
public class BookingServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.soap.cts.com/", "BookingServiceImplService");
    public final static QName BookingServiceImplPort = new QName("http://ws.soap.cts.com/", "BookingServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/soap-ticket-booking-service/BookingService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BookingServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/soap-ticket-booking-service/BookingService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BookingServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BookingServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookingServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BookingServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BookingServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BookingServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BookingService
     */
    @WebEndpoint(name = "BookingServiceImplPort")
    public BookingService getBookingServiceImplPort() {
        return super.getPort(BookingServiceImplPort, BookingService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookingService
     */
    @WebEndpoint(name = "BookingServiceImplPort")
    public BookingService getBookingServiceImplPort(WebServiceFeature... features) {
        return super.getPort(BookingServiceImplPort, BookingService.class, features);
    }

}
