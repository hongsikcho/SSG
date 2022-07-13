package com.ll.exam;

public class rq{
    String path;
    String url;
    String query;

    rq(){
        String[] sBits = url.split("\\?" , 2);
        this.path = sBits[0];

        if (sBits.length == 2){
            this.query = sBits[1];
        }
    }


    public String getPath(){
        return query;
    }

    public int getIntParam(String paramName , int defaultvalue){
        if(query == null){
            return defaultvalue;
        }

        String[] bits = query.split("&");

        for(String bit : bits){
            String[] nameValue = bit.split("=");
            String name = nameValue[0];
            String value = nameValue[1];

            if(name == paramName){
                return Integer.parseInt(value);
            }
        }

        return defaultvalue;
    }
}