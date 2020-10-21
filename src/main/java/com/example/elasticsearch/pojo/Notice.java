package com.example.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * @class_name: Notice
 * @description:
 * @author: huchaochao
 * @create: 2020-01-20 16:37
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
//indexName代表所以名称,type代表表名称
@Document(indexName = "wantu_notice_info", type = "doc")
public class Notice {

    //id
    @JsonProperty("auto_id")
    private Long id;

    //标题
    @JsonProperty("title")
    private String title;

    //公告标签
    @JsonProperty("exchange_mc")
    private String exchangeMc;

    //公告发布时间
    @JsonProperty("create_time")
    private String originCreateTime;

    //公告阅读数量
    @JsonProperty("read_count")
    private Integer readCount;

}