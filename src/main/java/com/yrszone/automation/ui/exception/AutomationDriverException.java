package com.yrszone.automation.ui.exception;


/**
 * Constructs and initializes the AutomationDriverException
 * @param message
 * @param cause 
 */
public class AutomationDriverException extends RuntimeException{
    private static final long serialVersionUID = 0x1L;

    public AutomationDriverException(final String message, final Throwable cause){
        super(message, cause);
    }
    public AutomationDriverException(final String message){
        super(message);
    }
}
