package io.zipcoder.tc_spring_poll_application.dto.error;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorDetail {

    private String title;               // brief title of error condition, ex. "Validation Failure" or "Internal Server Error"
    private int status;                 // HTTP status code for current request; redundant but useful for client-side error handling
    private String detail;              // short, human-readable description of the error that may be presented to user
    private long timeStamp;             // time in milliseconds when error occurred
    private String path;
    private String developerMessage;    // detailed info such as exception class name or a stack trace useful for developers to debug
    private Map<String, List<ValidationError>> errors = new HashMap<String,  // Map holds String-ErrorType name, Value - list of errors assoc w that type
                List<ValidationError>>();


    public ErrorDetail() {}


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

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, List<ValidationError>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<ValidationError>> errors) {
        this.errors = errors;
    }
}
