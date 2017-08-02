package com.ulb.web.demo;

import java.util.HashMap;
import java.util.Map;


public enum EventTypeEnum {
	suite_ticket("suite_ticket",1,"suite_ticket"),
	tmp_auth_code("tmp_auth_code",2,"tmp_auth_code"),
	change_auth("change_auth",3,"change_auth"),
	check_create_suite_url("check_create_suite_url",4,"check_create_suite_url"),
	check_update_suite_url("check_update_suite_url",5,"check_update_suite_url");

    
    private String code;
    private Integer id;
    private String desc;

    EventTypeEnum(String code, Integer id, String desc) {
        this.id = id;
        this.code = code;
        this.desc = desc;
    }
    
    

    
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map getEnumMap(){
    	EventTypeEnum[] enums = EventTypeEnum.values();
        Map m = new HashMap();
        int c = EventTypeEnum.values().length;
        for (int i = 0;i<c;i++){
            m.put(enums[i].code,enums[i]);
        }
        return m;
    }
    
    public static Integer getIdByCode(String code){
    	EventTypeEnum[] enums = EventTypeEnum.values();
        int c = EventTypeEnum.values().length;
        Integer id = 0;
        for (int i = 0;i<c;i++){
        	if(enums[i].code.equals(code)){
        		id=enums[i].id;
        	}
        }
        return id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
