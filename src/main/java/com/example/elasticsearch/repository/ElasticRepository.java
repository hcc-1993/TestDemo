package com.example.elasticsearch.repository;

import com.example.elasticsearch.pojo.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @class_name: ElasticRepository
 * @description:
 * @author: huchaochao
 * @create: 2020-01-20 15:54
 **/
public interface ElasticRepository extends ElasticsearchRepository<DocBean, Long> {

    //默认的注释
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
    Page<DocBean> findByContent(String content, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}")
    Page<DocBean> findByFirstCode(String firstCode, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?\"}}}}")
    Page<DocBean> findBySecordCode(String secordCode, Pageable pageable);

}
