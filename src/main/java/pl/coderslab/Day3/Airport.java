package pl.coderslab.Day3;

import java.time.LocalDateTime;

public class Airport {

    private String name;
    private int code;
    private LocalDateTime timezone;

    public Airport(String name, int code, LocalDateTime timezone) {
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getTimezone() {
        return timezone;
    }

    public void setTimezone(LocalDateTime timezone) {
        this.timezone = timezone;
    }
}