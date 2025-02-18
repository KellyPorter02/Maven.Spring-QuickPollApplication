package io.zipcoder.tc_spring_poll_application.exception;

import io.zipcoder.tc_spring_poll_application.dto.error.ErrorDetail;
import io.zipcoder.tc_spring_poll_application.dto.error.ValidationError;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    private MessageSource messageSource;


    @Autowired
    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // resets the information block that you get when you throw a 404 error for trying to access a resource that does not exist
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rNFEx, HttpServletRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("Resource not found");
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setDetail(rNFEx.getMessage());
        errorDetail.setDeveloperMessage(rNFEx.getClass().getName());
        errorDetail.setTimeStamp(new Date().getTime());
        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }

    // resets the info block that you get when you throw an error for not properly respecting the constraints put in the poll
    // class, a poll's question can't be null & you can't have < 2  or > 6 options for the answer
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorDetail handleValidationError(MethodArgumentNotValidException mANVEx, HttpServletRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();    // creates new errorDetail object
                errorDetail.setTitle("Validation Failed");
                errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
                errorDetail.setDetail("Input Validation did not pass");
                errorDetail.setDeveloperMessage(mANVEx.getClass().getName());
                errorDetail.setTimeStamp(new Date().getTime());
                String requestPath = (String) request.getAttribute("javax.servlet.error.request_uri");
                if(requestPath == null) {
                    requestPath = request.getRequestURI();
                }
                errorDetail.setPath(requestPath);

        List<FieldError> fieldErrorsList = mANVEx.getBindingResult().getFieldErrors();
            for (FieldError fieldErr: fieldErrorsList) {    // get list of errors from the methodArgumentNotValidException,
                                                            // for each error, add
                                                            // it to the appropriate list in the error detail map list
                List<ValidationError> validationErrorList = errorDetail.getErrors().get(fieldErr.getField());
                if (validationErrorList == null) {
                    validationErrorList = new ArrayList<>();
                    errorDetail.getErrors().put(fieldErr.getField(), validationErrorList);
                }
                ValidationError validationError = new ValidationError();
                validationError.setCode(fieldErr.getCode());
                validationError.setMessage(messageSource.getMessage(fieldErr, null));
                validationErrorList.add(validationError);
            }
        return errorDetail;
    }


}
