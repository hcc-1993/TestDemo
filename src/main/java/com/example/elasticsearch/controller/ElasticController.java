package com.example.elasticsearch.controller;
import com.example.elasticsearch.pojo.DocBean;
import com.example.elasticsearch.repository.ElasticRepository;
import com.example.elasticsearch.service.ElasticService;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @class_name: ElasticController
 * @description:
 * @author: huchaochao
 * @create: 2020-01-20 16:00
 **/
@Log4j2
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private ElasticService elasticService;
    @Autowired
    private ElasticRepository elasticRepository;

    @GetMapping("/init")
    public void init(){
        elasticService.createIndex();
        List<DocBean> list =new ArrayList<>();
        list.add(new DocBean(1L,"XX0193","XX8064","xxxxxx",1));
        list.add(new DocBean(2L,"XX0210","XX7475","xxxxxxxxxx",1));
        list.add(new DocBean(3L,"XX0257","XX8097","xxxxxxxxxxxxxxxxxx",1));
        elasticService.saveAll(list);
    }

    @GetMapping("/all")
    public Iterator<DocBean> all(){

        return elasticService.findAll();
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchKey") String searchKey) {
        String searchs = "";

        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("userName", searchKey));
        // 搜索，获取结果
        Page<DocBean> items = elasticRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();

        return searchs;
    }

}

