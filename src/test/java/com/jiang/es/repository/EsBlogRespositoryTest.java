package com.jiang.es.repository;

import com.jiang.SpringbootMybatisApplication;
import com.jiang.es.domain.EsBlog;
import javafx.beans.binding.BooleanExpression;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.stream.LongStream.of;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class EsBlogRespositoryTest {

    @Autowired
    private EsBlogRespository esBlogRespository;

    @Before
    public void RespositoryData()
    {
        esBlogRespository.deleteAll();
        esBlogRespository.save(new EsBlog("1","等和楼","王焕之",
                "拜入"));
        esBlogRespository.save(new EsBlog("相思","相思",
                "相思南斗"));  // 关键字"妹"
        esBlogRespository.save(new EsBlog("静夜思","老卫和你一起学 Elasticsearch",
                "如何来学习 Elasticsearch，最终看我的博客 https://waylau.com，酒")); // 关键字"酒"

        esBlogRespository.save(new EsBlog("4","03-05 用大白话聊聊分布式系统",
                "一提起“分布式系统”，大家的第一感觉就是好高大上啊，深不可测"));
        esBlogRespository.save(new EsBlog("5","02-19 Thymeleaf 3 引入了新的解析系统",
                "如果你的代码使用了 HTML5 的标准，而Thymeleaf 版本来停留在 2.x ，那么如果没有把闭合"));
        esBlogRespository.save(new EsBlog("6","02-19 使用 GFM Eclipse 插件时，不在项目里面生成 HTML 文件",
                "GFM 是 GitHub Flavored Markdown Viewer 的简称，是一款对 GitHub 友好的 Markdown 编辑器 。"));
    }


    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingTest() {
        Pageable pageable = PageRequest.of(0,20);
        String title = "思";
        String summary = "相思";
        String content = "相思";

        Page<EsBlog> page = esBlogRespository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        System.out.println("-------------start 1");
        assertThat(page.getTotalElements()).isEqualTo(2);
        for(EsBlog blog : page.getContent()){
            System.out.println(blog.toString());
        }
        System.out.println("-------------end 1");
    }

    @Test
    public void  save(){
        esBlogRespository.save(new EsBlog("1","等ddddddddddd和楼","王焕之",
                "拜入"));

    }


    @Test
    public void delete(){

        esBlogRespository.deleteById("CLVu6nEBY5fYTMIUQr00");
    }



}