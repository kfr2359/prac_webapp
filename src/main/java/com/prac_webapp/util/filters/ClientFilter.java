package com.prac_webapp.util.filters;

import java.util.Date;
import java.util.List;

public class ClientFilter {
    private List<String> employeesId;
    private List<String> serviceTypesId;
    private String startDate;
    private String endDate;

    public List<String> getServiceTypesId() {
        return serviceTypesId;
    }

    public void setServiceTypesId(List<String> serviceTypesId) {
        this.serviceTypesId = serviceTypesId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(List<String> employeesId) {
        this.employeesId = employeesId;
    }
}
