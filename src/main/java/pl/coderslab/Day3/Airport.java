package pl.coderslab.Day3;

import java.time.LocalDateTime;

public class Airport {

    private String name;
    private String code;
    private String timezone;

    public Airport(String name, String code, String timezone) {
        this.name = name;
        this.code = code;
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}