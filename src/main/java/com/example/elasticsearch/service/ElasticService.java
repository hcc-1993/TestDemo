package com.example.elasticsearch.service;

import com.example.elasticsearch.pojo.DocBean;
import com.example.elasticsearch.repository.ElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @class_name: ElasticService
 * @description:
 * @author: huchaochao
 * @create: 2020-01-20 15:58
 **/

@Service("elasticService")
public class ElasticService{

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);


    public void createIndex() {
        elasticsearchTemplate.createIndex(DocBean.class);
    }


    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    public void save(DocBean docBean) {
        elasticRepository.save(docBean);

    }


    public void saveAll(List<DocBean> list) {
        elasticRepository.saveAll(list);
    }


    public Iterator<DocBean> findAll() {
        return elasticRepository.findAll().iterator();
    }

    public Page<DocBean> findByContent(String content) {
        return elasticRepository.findByContent(content,pageable);
    }


    public Page<DocBean> findByFirstCode(String firstCode) {
        return elasticRepository.findByFirstCode(firstCode,pageable);
    }


    public Page<DocBean> findBySecondCode(String secondCode) {
        return elasticRepository.findBySecordCode(secondCode,pageable);
    }


    public Page<DocBean> query(String key) {
        return elasticRepository.findByContent(key,pageable);
    }

}

