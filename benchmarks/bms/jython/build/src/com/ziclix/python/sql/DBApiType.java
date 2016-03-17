/*
 * Jython Database Specification API 2.0
 *
 * $Id: DBApiType.java 4216 2008-03-17 22:17:05Z cgroves $
 *
 * Copyright (c) 2001 brian zimmer <bzimmer@ziclix.com>
 *
 */
package com.ziclix.python.sql;

import org.python.core.PyClass;
import org.python.core.PyInteger;

/**
 * This class wraps the types from java.sql.Type in order for
 * PyCursor to differentiate between a regular PyInteger and
 * a SQL datatype value.
 *
 * @author brian zimmer
 * @author last modified by $Author: cgroves $
 * @version $Revision: 4216 $
 */
public final class DBApiType extends PyInteger {

    /**
     * Constructor DBApiType
     *
     * @param type
     */
    public DBApiType(int type) {
        super(type);
    }

    /**
     * Constructor DBApiType
     *
     * @param type
     */
    public DBApiType(Integer type) {
        super(type.intValue());
    }
}
