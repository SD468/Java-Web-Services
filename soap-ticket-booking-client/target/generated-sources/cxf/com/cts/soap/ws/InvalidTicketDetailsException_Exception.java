
package com.cts.soap.ws;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 4.0.0
 * 2023-05-05T17:16:49.663+05:30
 * Generated source version: 4.0.0
 */

@WebFault(name = "InvalidTicketDetailsException", targetNamespace = "http://ws.soap.cts.com/")
public class InvalidTicketDetailsException_Exception extends Exception {

    private com.cts.soap.ws.InvalidTicketDetailsException faultInfo;

    public InvalidTicketDetailsException_Exception() {
        super();
    }

    public InvalidTicketDetailsException_Exception(String message) {
        super(message);
    }

    public InvalidTicketDetailsException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public InvalidTicketDetailsException_Exception(String message, com.cts.soap.ws.InvalidTicketDetailsException invalidTicketDetailsException) {
        super(message);
        this.faultInfo = invalidTicketDetailsException;
    }

    public InvalidTicketDetailsException_Exception(String message, com.cts.soap.ws.InvalidTicketDetailsException invalidTicketDetailsException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = invalidTicketDetailsException;
    }

    public com.cts.soap.ws.InvalidTicketDetailsException getFaultInfo() {
        return this.faultInfo;
    }
}
