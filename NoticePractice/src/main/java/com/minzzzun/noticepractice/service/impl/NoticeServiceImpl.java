package com.minzzzun.noticepractice.service.impl;

import com.minzzzun.noticepractice.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    List<Map<String, Object>> list = new ArrayList<>();
    int indexNumber = 1 ;


    @Override
    public int create(String title, String content, String author) {
        Map<String, Object> notice = new HashMap<>();
        notice.put("title", title);
        notice.put("content", content);
        notice.put("author", author);
        notice.put("id",indexNumber+1);
        list.add(notice);
        return 200;
    }

    @Override
    public void update(Map<String, Object> param) {
        int id = Integer.parseInt(param.get("id")+ "");
        Map<String, Object> notice = detail(id);

        if(notice != null){
            String title = (String) notice.get("title");
            if(title != null && !title.isEmpty()){
                notice.put("title", title);
            }
            String content = (String) notice.get("content");
            if(content != null && !content.isEmpty()){
                notice.put("content", content);
            }
        }
    }

    @Override
    public void delete(int id) {

    }



    @Override
    public List<Map<String, Object>> list(String title, String author) {
        if((title== null || title.isEmpty()) && author == null || author.isEmpty()) {
            return list;
        }

        List<Map<String, Object>> returnList = new ArrayList<>();
        for(Map<String, Object> each : list){
            boolean needToAdd = false;
            String eachTitle = (String) each.get("title");
            String eachAuthor = (String) each.get("author");
            if(title != null && !title.isEmpty()){
                if(eachTitle.contains(title)){
                    needToAdd = true;
                }
            }
            if(author != null && !author.isEmpty()){
                if(eachAuthor.contains(author)){
                    needToAdd = true;
                }
            }

            if (needToAdd) {
                returnList.add(each);
            }
        }
        return returnList;
    }

    @Override
    public Map<String, Object> detail(int id) {
        for (Map<String, Object> each: list ){
            if(each !=null) {
                int eachId = (Integer) each.get("id");
                if (eachId == id) {
                    return each;
                }
            }
        }
        return null;
    }


}
