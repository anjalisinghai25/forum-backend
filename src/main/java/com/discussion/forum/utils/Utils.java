package com.discussion.forum.utils;


import com.discussion.forum.constants.Constant;
import com.discussion.forum.exception.GlobalException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.codec.Base64;


import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    @SneakyThrows
    public static LocalDateTime stringToLocalDateTime(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_TIME_FORMAT);
            return LocalDateTime.parse(date, formatter);
        } catch (Exception e) {
            throw new GlobalException("Date Format must be : '" + Constant.DATE_TIME_FORMAT + "'");
        }
    }

    @SneakyThrows
    public static LocalDate stringToLocalDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new GlobalException("Date Format must be : '" + Constant.DATE_FORMAT + "'");
        }
    }

    @SneakyThrows
    public static String localDateToSting(LocalDate date) {
        try {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
            return date.format(formatters);
        } catch (Exception e) {
            throw new GlobalException("Date Format must be : '" + Constant.DATE_FORMAT + "'");
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @SneakyThrows
    public static <T> T copyValue(Object to, Object from, Class<T> className) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        to = to != null ? to : className.getConstructor().newInstance();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        from = mapper.convertValue(from != null ? from : new HashMap<>(), HashMap.class);
        HashMap<String, Object> toMap = mapper.convertValue(to, HashMap.class);
        toMap.putAll(mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).convertValue(from, HashMap.class));

        return mapper.convertValue(toMap, className);
    }

    @SneakyThrows
    public static <T> T mapValue(Object from, Class<T> className) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        from = mapper.convertValue(from != null ? from : new HashMap<>(), HashMap.class);
        HashMap<String, Object> toMap = mapper.convertValue(className.getConstructor().newInstance(), HashMap.class);
        toMap.putAll(mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).convertValue(from, HashMap.class));
        return mapper.convertValue(toMap, className);
    }


    public static Long getPagesByElementsAndSize(Long totalElements, Integer size) {
        return totalElements % size == 0 ? totalElements / size : (totalElements / size) + 1;
    }

}
