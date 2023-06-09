package com.onefiter.xr.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onefiter.xr.bean.base.DateBean;

public class Education extends DateBean {
    private String name;
    private String intro;
    /**
     * 0: 其它
     * 1: 小学
     * 2: 初中
     * 3: 高中
     * 4: 中专
     * 5: 大专
     * 6: 本科
     * 7: 硕士
     * 8: 博士
     */
    private Integer type;

    @JsonIgnore
    public String getTypeString() {
        switch (type) {
            case 1: return "小学";
            case 2: return "初中";
            case 3: return "高中";
            case 4: return "中专";
            case 5: return "大专";
            case 6: return "本科";
            case 7: return "硕士";
            case 8: return "博士";
            default: return "其它";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    public static void main(String[] args) throws Exception {
//        Education education = new Education();
//        education.setName("黄金小学");
//        education.setIntro("还不错的小学");
//        education.setType(4);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(education);
//        // {"id":null,"createdTime":null,"name":"黄金小学","intro":"还不错的小学","beginDay":null,"endDay":null,"type":4,"typeString":"中专"}
//        System.out.println(jsonString);
//    }
}
