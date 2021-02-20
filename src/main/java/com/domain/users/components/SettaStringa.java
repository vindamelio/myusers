package com.domain.users.components;

import java.util.Map;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class SettaStringa {

	private String stringa = "";
	private Integer count = 0;
    
    public SettaStringa() {
        this.stringa = "SettaStringa conteggio: " + this.count;
	}

	
	public SettaStringa(String stringa, Integer count) {
			this.stringa = stringa;
            this.count = count;
            this.stringa = "SettaStringa conteggio: " + this.count;            
	}
	
	
	public String getStringa() {
		return stringa;
	}
	public void setStringa(String stringa) {
		this.stringa = stringa;
	}


    public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
        this.count = count;
	}

	public void addCount() {
        this.count = this.count + 1;

        Integer module = this.count % 10;
        if(module == 0){
            this.stringa = "SettaStringa conteggio: " + this.count;
        }    
        //System.out.println("SettaStringa:" + count);
	}

    @Override
    public String toString() {
        return "SettaStringa [stringa=" + stringa + ", count=" + count + "]";
    }

    

}