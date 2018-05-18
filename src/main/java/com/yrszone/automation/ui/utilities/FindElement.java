package com.yrszone.automation.ui.utilities;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindElement {

    String page() default "";
    String field() default "";
}
