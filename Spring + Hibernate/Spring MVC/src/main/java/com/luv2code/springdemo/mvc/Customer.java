package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.annotation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName="";

    @NotNull(message = "is required")
    @Min(value = 0 ,message = "must be equal to 0 or higher")
    @Max(value = 10,message = "must be equal to 10 or lower")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 digits/charc")
    private String postalCode;

    @NotNull(message = "is required")
    @CourseCode(value = "MESSI",message = "must start with MESSI")
    private String cCode;

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
