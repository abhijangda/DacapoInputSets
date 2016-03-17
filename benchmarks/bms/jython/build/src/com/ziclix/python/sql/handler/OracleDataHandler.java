/*
 * Jython Database Specification API 2.0
 *
 * $Id: OracleDataHandler.java 6261 2009-04-24 12:45:27Z otmarhumbel $
 *
 * Copyright (c) 2001 brian zimmer <bzimmer@ziclix.com>
 *
 */
package com.ziclix.python.sql.handler;

import com.ziclix.python.sql.DataHandler;
import com.ziclix.python.sql.FilterDataHandler;
import com.ziclix.python.sql.zxJDBC;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;
import oracle.sql.BLOB;
import oracle.sql.ROWID;
import org.python.core.Py;
import org.python.core.PyObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Oracle specific data handling.
 *
 * @author brian zimmer
 * @author last revised by $Author: otmarhumbel $
 * @version $Revision: 6261 $
 */
public class OracleDataHandler extends FilterDataHandler {

    /**
     * Default constructor for DataHandler filtering.
     */
    public OracleDataHandler(DataHandler datahandler) {
        super(datahandler);
    }

    /**
     * Method getMetaDataName
     *
     * @param name
     * @return String
     */
    public String getMetaDataName(PyObject name) {

        String metaName = super.getMetaDataName(name);

        return (metaName == null) ? null : metaName.toUpperCase();
    }

    /**
     * Provide functionality for Oracle specific types, such as ROWID.
     */
    public void setJDBCObject(PreparedStatement stmt, int index, PyObject object, int type) throws SQLException {

        if (DataHandler.checkNull(stmt, index, object, type)) {
            return;
        }

        switch (type) {

            case OracleTypes.ROWID:
                stmt.setString(index, (String) object.__tojava__(String.class));
                break;

            case Types.DECIMAL:

                // Oracle is annoying
                Object input = object.__tojava__(Double.class);

                if (input != Py.NoConversion) {
                    stmt.setDouble(index, ((Double) input).doubleValue());

                    break;
                }

                super.setJDBCObject(stmt, index, object, type);
                break;

            case Types.NUMERIC:
                super.setJDBCObject(stmt, index, object, Types.DOUBLE);
                break;

            case Types.BLOB:
            case Types.CLOB:
                Integer[] vals = {new Integer(index), new Integer(type)};
                String msg = zxJDBC.getString("errorSettingIndex", vals);

                throw new SQLException(msg);
            default :
                super.setJDBCObject(stmt, index, object, type);
        }
    }

    /**
     * Provide functionality for Oracle specific types, such as ROWID.
     */
    public PyObject getPyObject(ResultSet set, int col, int type) throws SQLException {

        PyObject obj = Py.None;

        switch (type) {

            case Types.BLOB:
                BLOB blob = ((OracleResultSet) set).getBLOB(col);

                if (blob == null) {
                    return Py.None;
                }

                InputStream stream = new BufferedInputStream(blob.getBinaryStream());

                obj = Py.java2py(DataHandler.read(stream));
                break;

            case OracleTypes.ROWID:
                ROWID rowid = ((OracleResultSet) set).getROWID(col);

                if (rowid != null) {
                    obj = Py.java2py(rowid.stringValue());
                }
                break;

            default :
                obj = super.getPyObject(set, col, type);
        }

        return (set.wasNull() ? Py.None : obj);
    }

    /**
     * Called when a stored procedure or function is executed and OUT parameters
     * need to be registered with the statement.
     *
     * @param statement
     * @param index the JDBC offset column number
     * @param colType the column as from DatabaseMetaData (eg, procedureColumnOut)
     * @param dataType the JDBC datatype from Types
     * @param dataTypeName the JDBC datatype name
     * @throws SQLException
     */
    public void registerOut(CallableStatement statement, int index, int colType, int dataType, String dataTypeName) throws SQLException {

        if (dataType == Types.OTHER) {
            if ("REF CURSOR".equals(dataTypeName)) {
                statement.registerOutParameter(index, OracleTypes.CURSOR);

                return;
            } else if ("PL/SQL RECORD".equals(dataTypeName)) {
                statement.registerOutParameter(index, OracleTypes.CURSOR);

                return;
            }
        }

        super.registerOut(statement, index, colType, dataType, dataTypeName);
    }
}
