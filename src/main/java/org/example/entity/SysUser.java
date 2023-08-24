package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xhj
 * @since 2022/9/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "user_id", type = IdType.ASSIGN_ID)
	private Long userId;

	private String username;

	private String password;

	/**
	 * 随机盐
	 */
	@JsonIgnore
	private String salt;

	private String lockFlag;

	private String phone;

	private String avatar;

	@TableField(exist = false)
	private String deptName;

	@TableField(exist = false)
	private Long superDeptId;

	@TableField(exist = false)
	private String superDeptName;

	/**
	 * 0-正常，1-删除
	 */
	@TableLogic
	private String delFlag;
	/**
	 * 用户域账号
	 */
	private String domainLogin;
	/**
	 * 员工编号
	 */
	private String employeeNumber;
	/**
	 * 用户姓名
	 */
	private String trueName;
	/**
	 * 上级领导
	 */
	private Long leaderUid;

	/**
	 * 用户性别：0=男；1=女；
	 */
	private String sex;
	/**
	 * 电子邮箱
	 */
	private String email;
}
