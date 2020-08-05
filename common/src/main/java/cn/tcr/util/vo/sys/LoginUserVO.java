package cn.tcr.util.vo.sys;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/19 18:52
 */
@Data
//@ApiModel(value="登录信息", description="后台用户信息")
public class LoginUserVO {

//    @ApiModelProperty(value = "用户名")
    private String username;

//    @ApiModelProperty(value = "密码")
    private String password;
}
