package com.sifude.lejane.exception;

import com.sifude.exception.ISifudeExceptionEnum;


/**
 * <h4>异常说明</h4>
 * <ul>
 * <li>0000~0999:数据库异常</li>
 * <li>1000~1999:空指针异常</li>
 * <li>2000~2999:参数是否合法</li>
 * <li>3000~3999:参数验证</li>
 * <li>4000~4999:对接异常</li>
 * <li>7000~7999:io异常</li>
 * <li>8000~8999:系统异常</li>
 * <li>9000~9999:其他异常</li>
 * <ul>
 * 
 * 
 * @author 梁景皓###
 * 
 */
public enum SifudeLejaneExceptionEnum implements ISifudeExceptionEnum{
	
	SQL_ERROR("0000", "数据库异常{0}"),
	
	QUERY_ERROR("0100", "查询数据异常"),
	
	QUERY_ZERO_ERROR("0110", "查询0条数据"),
	
	INSERT_ERROR("0200", "插入数据异常"),
	
	UPDATE_ERROR("0300", "更新数据异常"),

	UPDATE_ZERO_ERROR("0310", "更新0条数据"),
	
	DELETE_ERROR("0400", "删除数据异常"),

	DELETE_ZERO_ERROR("0410", "删除0条数据"),
	
	PARAM_IS_NULL("1000", "参数{0}为空"),
	
	EMPLOYEE_STORE_IS_NULL("1001", "员工所在店铺为空"),

	VICE_MANAGER_STORE_IS_NULL("1002", "副店长所在店铺为空"),

	VICE_MANAGER_GROUP_IS_NULL("1003", "副店长所在小组为空"),

	MANAGER_STORE_IS_NULL("1004", "店长所在店铺为空"),
	
	PARAM_ILLEGAL("2000", "参数{0}不合法"),
	
	XY_ILLEGAL("2001", "坐标x={0},y={1}不合法"),
	
	PARAN_EXCEPTION("3000", "参数验证"),
	
	USER_WRONG_EXCEPTION("3001", "用户不存在"),
	
	PASSWORD_WRONG_EXCEPTION("3002", "密码错误"),
	
	USER_DELETE_EXCEPTION("3003", "用户已经被管理员删除"),
	
	USER_ROLE_WRONG_EXCEPTION("3004", "用户角色不正确"),
	
	USER_PARENT_DELETE_EXCEPTION("3005", "用户超级管理账号已被删除"),
	
	USER_PRAENT_WAIT_EXCEPTION("3006", "您的账号服务时间未到，请耐心等待"),
	
	USER_UNLOG_EXCEPTION("3007", "用户未登录"),
	
	VALIDATE_CODE_WRONG_EXCEPTION("3008", "验证码错误"),
	
	VALIDATE_CODE_NOTEXIST_EXCEPTION("3015", "登陆错误次数超过3次，请输入验证码"),
	
	USER_PRAENT_EIPIRE_EXCEPTION("3009", "您的账号已过期，请联系客服续费！"),
	
	USER_EXIST_EXCEPTION("3010", "用户:{0},已经存在"),
	
	PHONE_EXIST_EXCEPTION("3011", "电话号码:{0},已经存在"),
	
	IDCARD_EXIST_EXCEPTION("3012", "身份证号:{0},已经存在"),
	
	SAFETYID_EXIST_EXCEPTION("3013", "safetyId:{0},已经存在"),
	
	COMP_EXIST_EXCEPTION("3014", "公司名称:{0},已经存在"),
	
	QUESTION_EXIST_EXCEPTION("3015", "密保问题已经存在"),
	
	ROLE_NAME_EXIST_EXCEPTION("3016", "用户角色名:{0},已经存在"),
	
	GUEST_EXIST_EXCEPTION("3017", "客户名称:{0},已经存在"),
	
	FACTORY_EXIST_EXCEPTION("3018", "厂家名称:{0},已经存在"),
	
	STORE_EXIST_EXCEPTION("3019", "店铺名称:{0},已经存在"),
	
	TOKEN_EXPIRE_EXCEPTION("3020", "token={0}已经过期"),
	
	USER_ROLE_ILLEGAL_EXCEPTION("3021", "用户角色roleId={0}不合法"),
	
	USER_SAFETYID_ILLEGAL_EXCEPTION("3022", "safetyId={0}不合法"),
	
	USER_ADDID_ILLEGAL_EXCEPTION("3023", "操作着addId={0}不合法"),
	
	USER_STORE_ILLEGAL_EXCEPTION("3024", "操作者店铺addStoreId={0}不合法"),
	
	USER_COMPANY_ILLEGAL_EXCEPTION("3025", "操作着公司addCompId={0}不合法"),
	
	USER_PERMISSON_ILLEGAL_EXCEPTION("3026", "用户角色没有操作权限"),
	
	ROLE_LEVEL_ILLEGAL_EXCEPTION("3027", "用户角色基本roleLevel={0}不合法"),
	
	USER_OPID_ILLEGAL_EXCEPTION("3028", "用户addOpId={0}不合法"),
	
	TOKEN_NULL_EXCEPTION("3030", "token为空"),
	
	ROLE_NOT_EXIST_EXCEPTION("3031", "用户角色roleId={0}不存在"),
	
	STORE_NOT_EXIST_EXCEPTION("3032", "店铺storeId={0}不存在"),
	
	COMPANY_NOT_EXIST_EXCEPTION("3033", "公司compId={0}不存在"),
	
	CITY_NOT_EXIST_EXCEPTION("3034", "城市adcode={0}不存在"),
	
	ADDID_NOT_EXIST_EXCEPTION("3035", "操作着addId={0}不存在"),
	
	SERVER_NOT_EXIST_EXCEPTION("3036", "店员serverId={0}不存在"),
	
	COMPANY_EXIST_UNDERLING("3037", "机构存在下属机构"),
	
	TOKEN_ILLEGAL_EXCEPTION("3040", "token值非法"),
	
	STORE_ROLE_WRONG_EXCEPTION("3091", "店长身份不正确"),
	
	STORE_OUT_STATUS_WRONG_EXCEPTION("3092", "调出店铺未审核通过"),
	
	STORE_ROLE_EXIST_EXCEPTION("3093", "店铺已经存在店长"),
	
	STORE_VICE_ROLE_EXIST_EXCEPTION("3094", "店铺已经存在副店长"),
	
	ORDER_STATUS_ERROR_EXCEPTION("3095", "订单状态不正确,{0}"),
	
	USER_ANSWER_WRONG_EXCEPTION("3096", "密保答案不正确"),
	
	SUPEROP_EXIST_EXCEPTION("3097", "该平台下已经存在超级管理员，safetyId={0}"),
	
	COMPPID_WRONG_EXCEPATION("3098", "公司不能为自己的上级公司，comppId={0}"),
	
	COMPNAME_EXIST_EXCEPATION("3099", "机构名称已存在"),

	PROBLEM_EXIST_EXCEPTION("3101", "问题标题已经存在， title={0}"),

	PROBLEM_TYPE_NOT_EXIST_EXCEPTION("3102", "问题类型不存在, ptId={0}"),

	ARCHIVE_IMPORT_FORMAT_EXCEPATION("3103", "{0}格式错误"),

	ARCHIVE_TOMANT_EXCEPATION("3104", "健康档案超过{0}条"),
	
	CONNECT_ERROR("8000", "对接异常:code={0}, description={1}"),
	
	PUSH_MESSAGE_ERROR("8001", "消息推送异常"),
	
	CANNOT_CONNECT_ERROR("8002", "连接服务异常"),
	
	OTHER_ERROR("9000", "其他异常") ,
	
	IMAGE_TYPE_ERROR("9001", "图片格式不合法"),
	
	IMAGE_UPLOAD_ERROR("9002", "图片上传失败"),
	
	JSON_PRASE_ERROR("9003", "json格式不合法"),
	
	GTYPE_DELETE_ERROR("10002", "分类下存在商品不能进行删除操作"), 
	GTYPE_UPDATE_ERROR("10003", "分类数据编辑新增操作失败"), 
	BRAND_EXIST_EXCEPTION("4004", "品牌名称已存在"), 
	
	
	;
	
	private String code;
	private String message;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private SifudeLejaneExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public static String getMessage(String code) {
		for (SifudeLejaneExceptionEnum exp : values()) {
			if (exp.getCode().equals(code)) {
				return exp.getMessage();
			}
		}
		return null;
	}

	public String getMessage(String[] args) {
		String message = this.message;
		for(int i=0; i<args.length; i++) {
			message = message.replace("{" + i + "}", args[i]);
		}
		return message;
	}
}