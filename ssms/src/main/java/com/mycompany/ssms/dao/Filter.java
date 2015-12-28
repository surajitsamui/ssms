/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ssms.dao;

import java.util.List;
import org.dom4j.rule.Rule;

/**
 *
 * @author srini
 */
public class Filter {
 
    private String groupOp;
    private List<Rule> rules;
    private List<Filter> groups;

    /**
     * @return the groupOp
     */
    public String getGroupOp() {
        return groupOp;
    }

    /**
     * @param groupOp the groupOp to set
     */
    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    /**
     * @return the rules
     */
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * @param rules the rules to set
     */
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * @return the groups
     */
    public List<Filter> getGroups() {
        return groups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(List<Filter> groups) {
        this.groups = groups;
    }
}
