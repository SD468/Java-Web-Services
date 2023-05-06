
package com.cts.soap.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TicketId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ShowName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ScreenNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NoOfTickets" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticket", propOrder = {
    "ticketId",
    "bookingDate",
    "showName",
    "screenNumber",
    "noOfTickets"
})
public class Ticket {

    @XmlElement(name = "TicketId")
    protected int ticketId;
    @XmlElement(name = "BookingDate")
    protected String bookingDate;
    @XmlElement(name = "ShowName")
    protected String showName;
    @XmlElement(name = "ScreenNumber")
    protected String screenNumber;
    @XmlElement(name = "NoOfTickets")
    protected int noOfTickets;

    /**
     * Gets the value of the ticketId property.
     * 
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     */
    public void setTicketId(int value) {
        this.ticketId = value;
    }

    /**
     * Gets the value of the bookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingDate(String value) {
        this.bookingDate = value;
    }

    /**
     * Gets the value of the showName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowName() {
        return showName;
    }

    /**
     * Sets the value of the showName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowName(String value) {
        this.showName = value;
    }

    /**
     * Gets the value of the screenNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScreenNumber() {
        return screenNumber;
    }

    /**
     * Sets the value of the screenNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScreenNumber(String value) {
        this.screenNumber = value;
    }

    /**
     * Gets the value of the noOfTickets property.
     * 
     */
    public int getNoOfTickets() {
        return noOfTickets;
    }

    /**
     * Sets the value of the noOfTickets property.
     * 
     */
    public void setNoOfTickets(int value) {
        this.noOfTickets = value;
    }

}
