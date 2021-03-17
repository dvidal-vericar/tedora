package org.vericar.tedora.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Date;
import java.time.LocalDate;

/**
 * LocalDate converter to sql Date for EclipseLink.
 *
 * @version 1.0
 */
@Converter
public class LocalDateEclipse implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null
                : Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null
                : date.toLocalDate();
    }
}
