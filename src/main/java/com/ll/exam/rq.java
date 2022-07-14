package com.ll.exam;

public class rq{
    String path;
    String url;
    String query;

    rq(String cmd){
        String[] sBits = cmd.split("\\?" , 2);
        this.path = sBits[0];

        if (sBits.length == 2){
            this.query = sBits[1];
        }
    }


    public String getPath(){
        return path;
    }

    public int getIntParam(String paramName , int defaultvalue){
        if(query == null){
            return defaultvalue;
        }

        String[] bits = query.split("&");

        for(String bit : bits){
            String[] nameValue = bit.split("=",2);
            String name = nameValue[0];
            String value = nameValue[1];

            if(name.equals(paramName)){
                return Integer.parseInt(value);
            }
        }

        return defaultvalue;
    }
}