package com.example.parser_hh.controller;

import com.example.parser_hh.model.ParsingUrl;
import com.example.parser_hh.model.Resume;
import com.example.parser_hh.model.SearchFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resume")
public class ResumeController {
    private static ParsingUrl URL = new ParsingUrl(); // Глобальный адрес

    @GetMapping("/test")
    public List<Resume> Test() throws IOException {
        SearchFilter filter = new SearchFilter();

        filter.setText("Developer");
        filter.setExperience("between1And3");
        filter.setEmployment("full");
        filter.setSchedule("fullDay");

        AddressFormation(filter);

        return ParseResume();
    }

    @PostMapping("/setFilter")
    public void AddressFormation(@RequestBody SearchFilter filter) {
        // Формирование URL на основе полученного фильтра
        URL = new ParsingUrl(filter);
    }

    @GetMapping("/get")
    public List<Resume> ParseResume() throws IOException {

        List<Resume> resumeList = new ArrayList<>();

        // Парсинг страницы

        Document doc = Jsoup.connect(URL.getUrl()).get();

        // Получение всех блоков с резюме на странице

        Elements resumeContent = doc.select("div[class=resume-search-item__content]");

        // Получение необходимых полей блоков с резюме

        for(Element element : resumeContent) {
            Resume resume = new Resume();

            resume.setTitle(element.select(".serp-item__title").text());

            resume.setAge(element.select("div.resume-search-item__fullname").text());

            resume.setSalary(element.select("div.bloko-text.bloko-text_large.bloko-text_strong").text());

            resume.setStatus(element.select("div.resume-search-item__labels").text());

            resume.setExperience(element.select("div[data-qa='resume-serp__resume-excpirience-sum']").text());

            resume.setPreviousWork(element.select("span.bloko-text.bloko-text_strong").text());

            resume.setLink("https://voronezh.hh.ru" + element.select(".serp-item__title").attr("href"));

            resumeList.add(resume);
        }

        return resumeList;
    }
}
