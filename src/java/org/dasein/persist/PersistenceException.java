/* $Id: PersistenceException.java,v 1.1.1.1 2004/02/16 10:27:06 worthr Exp $ */
/* Copyright © 2002 George Reese, Imaginet */
package org.dasein.persist;

// Developed by George Reese for the book:
// Java Best Practices, Volume II: J2EE
// Ported to the digital@jwt code library by George Reese

/**
 * Represents an error accessing some sort of data store. This
 * class generally encapsulates an underlying data source exception
 * explaining the true nature of the error.
 * <br/>
 * Last modified $Date: 2004/02/16 10:27:06 $
 *
 * @author George Reese
 * @version $Revision: 1.1.1.1 $
 */
public class PersistenceException extends Exception {

    /**
     * The exception that led to this persistence problem.
     */
    private Exception cause = null;

    /**
     * Constructs a new persistence exception that appears to
     * have happened for new good readon whatsoever.
     */
    public PersistenceException() {
        super();
    }

    /**
     * Constructs a new persistence exception with the specified
     * explanation.
     *
     * @param msg the explanation for the error
     */
    public PersistenceException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new persistence exception that results from the
     * specified data store exception.
     *
     * @param cse the cause for this persistence exception
     */
    public PersistenceException(Exception cse) {
        super(cse.getMessage());
        cause = cse;
    }

    /**
     * @return the cause of this exception
     */
    public Throwable getCause() {
        return cause;
    }
}
