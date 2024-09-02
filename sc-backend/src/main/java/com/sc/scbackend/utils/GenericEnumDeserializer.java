package com.sc.scbackend.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sc.scbackend.base.IBaseEnum;

import java.io.IOException;
import java.util.Arrays;

public class GenericEnumDeserializer<T extends Enum<T> & IBaseEnum<?>> extends JsonDeserializer<T> {
    private final Class<T> enumClass;


    // 私有构造函数
    protected GenericEnumDeserializer(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    // 静态工厂方法
    public static <T extends Enum<T> & IBaseEnum<?>> GenericEnumDeserializer<T> create(Class<T> enumClass) {
        return new GenericEnumDeserializer<>(enumClass);
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IOException("Unknown value: " + value));
    }
}
