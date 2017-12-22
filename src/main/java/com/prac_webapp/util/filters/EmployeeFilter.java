package com.prac_webapp.util.filters;

import java.util.List;

public class EmployeeFilter {
    private List<String> clientsId;
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

    public List<String> getClientsId() {
        return clientsId;
    }

    public void setClientsId(List<String> clientsId) {
        this.clientsId = clientsId;
    }
}
