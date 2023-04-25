package controller;

public @interface RequestBody {
    boolean required() default true;
}
