package com.example.parser_hh.model;

public class ParsingUrl {
    private static String baseUrl = "https://voronezh.hh.ru/search/resume?area=26&ored_clusters=true&order_by=relevance&search_period=0&logic=normal&pos=full_text&exp_period=all_time";
    private String url;

    public ParsingUrl() {
        url = baseUrl;
    }

    public ParsingUrl(SearchFilter filter) {

        // Формирование URL

        url = baseUrl + "&text=" + filter.getText();

        if(filter.getExperience() != null) {
            url += "&experience=" + filter.getExperience();
        }

        if(filter.getEmployment() != null) {
            url += "&employment=" + filter.getEmployment();
        }

        if(filter.getSchedule() != null) {
            url += "&schedule=" + filter.getSchedule();
        }
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = baseUrl + url;
    }

}
