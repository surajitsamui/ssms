package com.mycompany.ssms.dao;
import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

public class JqGridData<T> {

    /**
     * Total number of pages
     */
    private int total;
    /**
     * The current page number
     */
    private int page;
    /**
     * Total number of records
     */
    private long records;
    /**
     * The actual data
     */
    private List<T> rows;
    private int noOfRowsPerPage;
    private String searchField;
    private String searchString;
    private String searchOper;

    private String filters;

    private Filter pfilters;

    public JqGridData() {
    }

    public JqGridData(Page<T> data) {
        this.rows = data.getContent();
        this.total = data.getTotalPages();
        this.page = data.getNumber() + 1;
        this.records = data.getTotalElements();
    }

    public JqGridData(String searchField, String searchString, String searchOper, List<T> rows) {
        this.searchField = searchField;
        this.searchOper = searchOper;
        this.searchString = searchString;
        this.rows = rows;
    }

    public JqGridData(int total, int page, long records, List<T> rows) {
        this.total = total;
        this.page = page;
        this.records = records;
        this.rows = rows;
    }

    public JqGridData(List<T> rows) {
        this.rows = rows;
        this.total = rows.size();
        this.page = 1;
        this.records = rows.size();
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        if (page == 0) {
            page = 1;
        }
        return page;
    }

    public long getRecords() {
        return records;
    }

    public List<T> getRows() {
        return rows;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getNoOfRowsPerPage() {
        if (noOfRowsPerPage == 0) {
            return 10;
        }
        return noOfRowsPerPage;
    }

    public void setRows(int noOfRowsPerPage) {
        this.noOfRowsPerPage = noOfRowsPerPage;
    }

    /**
     * @return the filters
     */
    public Filter getPfilters() {
        
        return pfilters;
    }

    /**
     * @param filters the filters to set
     */
    public void setPfilters(Filter filters) {
        this.pfilters = filters;
    }

    /**
     * @return the filters
     */
    public String getFilters() {
        return filters;
    }

    /**
     * @param filters the filters to set
     */
    public void setFilters(String filters) {
        this.filters = filters;
        if (StringUtils.hasText(filters)) {
            this.pfilters = JsonHelperClass.str2Object(filters, Filter.class);
        }
    }

    /**
     *
     * @return filter condition or "" in case no condition is given
     *
     */
    public String evalFilterToWhereCond() {
        StringBuilder b = new StringBuilder();
        if (StringUtils.hasText(this.filters)) { // multi options            
            for (org.dom4j.rule.Rule r : this.pfilters.getRules()) {
                if (b.length() > 0) {
                    b.append(' ').append(this.pfilters.getGroupOp()).append(' ');
                }
                //b.append(r.getField()).append(' ').append(operatorNameToSymb(r.getOp())).append(paddData(r.getOp(), r.getData()));
            }
        } else if (StringUtils.hasText(this.searchString)) { // basic search            
            b.append(" and ").append(this.searchField).append(operatorNameToSymb(this.searchOper)).append(paddData(this.searchOper, this.searchString));
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static String operatorNameToSymb(String operatorName) {
        String operatorSymb = "";
        if ("eq".equals(operatorName)) {
            operatorSymb = "=";
        } else if ("ne".equals(operatorName)) {
            operatorSymb = "!=";
        } else if ("lt".equals(operatorName)) {
            operatorSymb = "<";
        } else if ("le".equals(operatorName)) {
            operatorSymb = "<=";
        } else if ("gt".equals(operatorName)) {
            operatorSymb = ">";
        } else if ("ge".equals(operatorName)) {
            operatorSymb = ">=";
        } else if ("bw".equals(operatorName) || "cn".equals(operatorName) || "ew".equals(operatorName)) { // begins /contains/end with
            operatorSymb = " like ";
        } else if ("bn".equals(operatorName) || "nc".equals(operatorName) || "en".equals(operatorName)) { // not begin with
            operatorSymb = " not like ";
        } else if ("in".equals(operatorName)) {
            operatorSymb = " in ";
        } else if ("ni".equals(operatorName)) {
            operatorSymb = " not in ";
        }
        //['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
        return operatorSymb;
    }

    private String paddData(String operatorName, String data) {
        if ("bw".equals(operatorName) || "cn".equals(operatorName) || "ew".equals(operatorName) || "bn".equals(operatorName) || "nc".equals(operatorName) || "en".equals(operatorName)) { // not begin with
            return "'%" + data + "%'";
        }
        return "'" + data + "'";
    }

}
