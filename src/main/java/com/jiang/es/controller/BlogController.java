package com.jiang.es.controller;

import com.jiang.es.domain.EsBlog;
import com.jiang.es.repository.EsBlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsBlogRespository esBlogRespository;

    @RequestMapping
    public List<EsBlog> list(@RequestParam("title")String title,
                             @RequestParam("summary")String summary,
                             @RequestParam("content")String content,
                             @RequestParam(value = "pageIndex",defaultValue = "0")int pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "10")int pageSize
                             ){

        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<EsBlog> page = esBlogRespository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        return page.getContent();
    }
}
