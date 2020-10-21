package com.example.elasticsearch.repository;

/**
 * @class_name: NoticeRepository
 * @description:
 * @author: huchaochao
 * @create: 2020-01-20 16:39
 **/

import com.example.elasticsearch.pojo.Notice;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface NoticeRepository extends ElasticsearchRepository<Notice, Long> {

}
