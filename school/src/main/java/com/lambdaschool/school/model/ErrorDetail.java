package com.lambdaschool.school.model;

import com.lambdaschool.school.exceptions.ValidationError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorDetail
{
    private String title;
    private int status;
    private String detail;
    private String timestamp;
    private String developermessahe;
    private Map<String, List<ValidationError>> errors = new HashMap<>(  );

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = new SimpleDateFormat( "dd mmm yyyy HH:mm:ss:SSS z" ).format( new Date( timestamp));
    }

    public String getDevelopermessahe() {
        return developermessahe;
    }

    public void setDevelopermessahe(String developermessahe) {
        this.developermessahe = developermessahe;
    }

    public Map<String, List<ValidationError>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<ValidationError>> errors) {
        this.errors = errors;
    }
}
