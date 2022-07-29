package com.bbd.pritesh.response;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
public class Response {

	   private  String msg;
	   private Boolean status;
     
	   private Date timestamp;
	   static Response r;
	   public static Response send(String m,Boolean s) {
		  r=new Response();
		 r.setMsg(m);
		 r.setStatus(s);
		 r.setTimestamp(new Date());
		  return r;
	   }
}
