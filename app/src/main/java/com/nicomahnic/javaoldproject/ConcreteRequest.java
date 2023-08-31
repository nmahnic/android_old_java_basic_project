package com.nicomahnic.javaoldproject;

public class ConcreteRequest extends BaseRequest<ConcreteData> {
    protected ConcreteRequest() {
        super(new ConcreteMapper());
    }
}
