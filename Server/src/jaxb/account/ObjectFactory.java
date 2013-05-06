//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.30 um 11:49:43 PM CEST 
//


package jaxb.account;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Accounts }
     * 
     */
    public Accounts createAccounts() {
        return new Accounts();
    }

    /**
     * Create an instance of {@link Accounts.Account }
     * 
     */
    public Accounts.Account createAccountsAccount() {
        return new Accounts.Account();
    }

    /**
     * Create an instance of {@link Accounts.Account.Payments }
     * 
     */
    public Accounts.Account.Payments createAccountsAccountPayments() {
        return new Accounts.Account.Payments();
    }

    /**
     * Create an instance of {@link Accounts.Account.Users }
     * 
     */
    public Accounts.Account.Users createAccountsAccountUsers() {
        return new Accounts.Account.Users();
    }

    /**
     * Create an instance of {@link Accounts.Account.Users.User }
     * 
     */
    public Accounts.Account.Users.User createAccountsAccountUsersUser() {
        return new Accounts.Account.Users.User();
    }

    /**
     * Create an instance of {@link Accounts.Account.Payments.Bank }
     * 
     */
    public Accounts.Account.Payments.Bank createAccountsAccountPaymentsBank() {
        return new Accounts.Account.Payments.Bank();
    }

    /**
     * Create an instance of {@link Accounts.Account.Users.User.Genre }
     * 
     */
    public Accounts.Account.Users.User.Genre createAccountsAccountUsersUserGenre() {
        return new Accounts.Account.Users.User.Genre();
    }

}
