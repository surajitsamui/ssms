package com.mycompany.ssms.dao;

/**
 *
 * @author surajit
 */
public class Rule {

    private String field;
    private String op;
    private String data;

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return the op
     */
    public String getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

}
