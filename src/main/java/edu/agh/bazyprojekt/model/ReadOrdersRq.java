package edu.agh.bazyprojekt.model;

import org.springframework.format.datetime.joda.LocalDateParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ReadOrdersRq {
    private Date before;
    private Date after;
    private String dateField;
    private GroupBy groupBy;
    private Map<String, String> restrictions;

    public void setBefore(String stringDate) {
        this.before = Date.from(LocalDate.parse(stringDate).atStartOfDay().toInstant(ZoneOffset.UTC));
    }

    public void setAfter(String stringDate) {
        this.after = Date.from(LocalDate.parse(stringDate).atStartOfDay().toInstant(ZoneOffset.UTC));
    }

    public Optional<Date> getBefore() {
        return Optional.ofNullable(before);
    }

    public Optional<Date> getAfter() {
        return Optional.ofNullable(after);
    }

    public String getDateField() {
        return dateField;
    }

    public GroupBy getGroupBy() {
        return groupBy;
    }

    public Map<String, String> getRestrictions() {
        if(restrictions == null){
            restrictions = new HashMap<>();
        }
        return restrictions;
    }

    public enum GroupBy {
        PRODUCT,
        EMPLOYEE;
    }
}
