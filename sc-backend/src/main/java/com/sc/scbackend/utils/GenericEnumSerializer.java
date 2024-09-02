package com.sc.scbackend.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.sc.scbackend.base.IBaseEnum;

import java.io.IOException;

public class GenericEnumSerializer<T extends IBaseEnum<?>> extends JsonSerializer<T> {
    @Override
    public void serialize(T valueEnum, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(valueEnum.getValue().toString());
    }
}

