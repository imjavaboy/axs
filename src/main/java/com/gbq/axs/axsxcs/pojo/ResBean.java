package com.gbq.axs.axsxcs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResBean
 * @Description 公共返回对象
 * @Author guobenqi
 * @Date 2021/11/8 8:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResBean {
    private Integer code;
    private String message;
    private Object obj;

    /*成功返回*/
    public static ResBean success(String message){
        return new ResBean(200,message,null);
    }
    public static ResBean success(String message,Object obj){
        return new ResBean(200,message,obj);
    }
    /*失败返回*/
    public static ResBean error(String message){
        return new ResBean(500,message,null);
    }
    public static ResBean error(String message,Object obj){
        return new ResBean(500,message,obj);
    }


}
