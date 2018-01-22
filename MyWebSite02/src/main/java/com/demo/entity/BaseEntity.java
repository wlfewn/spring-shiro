package com.demo.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity extends BaseIdEntity{

	private static final long serialVersionUID = 1828424691528427971L;

	private Date createDate;//创建时间
	private Date updateDate;//修改时间
	
	public Date getCreateDate() {
		if(null == createDate)
			return new Date();
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		if(null == updateDate)
			return new Date();
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
