package com.decimal.springsecurity.rest.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class DateUtil {

    public static LocalDateTime epochToLocalDateTime(Long epoch) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.systemDefault());
    }

    public static LocalDate epochToLocalDate(Long epoch) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.systemDefault());
    }
}
