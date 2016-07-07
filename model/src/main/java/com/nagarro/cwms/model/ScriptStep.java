package com.nagarro.cwms.model;

import java.io.Serializable;
import java.util.List;

/**
 * Model class for carrying Script related data.
 * 
 */
public class ScriptStep implements Step, Serializable {

    /** Generated Serial Version Id */
    private static final long serialVersionUID = -5795415030372450110L;
    private long id;
    private String name;
    private String description;
    private String fileName;
    private List<String> paramNames;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public List<String> getParamNames() {
        return paramNames;
    }


    public void setParamNames(List<String> paramNames) {
        this.paramNames = paramNames;
    }

}
