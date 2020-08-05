package cn.tcr.util;

/**
 * @author TuTu
 * @date 2020/6/17 10:30
 */
public class ResultUtil {

    private String status;     // 状态
    private Object data;   // 返回值
//    private Exception e;   // 异常类捕获
    private String msg;    // 自定义信息

    public ResultUtil(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     *  普通请求成功返回信息
     * @param data
     * @return
     */
    public static ResultUtil success(Object data) {
        return new ResultUtil("200","请求成功！",data);
    }

    /**
     *  普通请求失败返回信息
     * @param msg
     * @return
     */
    public static ResultUtil failed(String msg) {
        return new ResultUtil("500", msg,null);
    }
}
