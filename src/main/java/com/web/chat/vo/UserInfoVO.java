package com.web.chat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoVO {
	private Integer uiNum;
	private String uiName, uiId, uiPwd;
	private int uiWin, uiTotal;
}
