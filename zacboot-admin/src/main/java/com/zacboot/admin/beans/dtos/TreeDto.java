package com.zacboot.admin.beans.dtos;

import com.zac.system.core.entity.admin.SysDept;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * 树形列表用到
 */
@Data
public class TreeDto implements Serializable {

	private static final long serialVersionUID = 4013193970046502756L;

	private Long key;

	private String title;

	private String slotTitle;

	private boolean isLeaf;

	private String icon;

	private Integer ruleFlag;

	private Map<String,String> scopedSlots;

	private String parentUuid;

	private String label;

	private Long value;

	private List<TreeDto> children;

	public TreeDto() {

	}

	/**
	 * 构建部门树
	 * @param sysDept
	 */
	public TreeDto(SysDept sysDept) {
        this.key = sysDept.getId();
        this.parentUuid = sysDept.getParentUuid();
        this.title = sysDept.getDepartName();
		this.slotTitle =  sysDept.getDepartName();
		this.value = sysDept.getId();
		this.label = sysDept.getDepartName();
	}

    public TreeDto(Long key, String parentUuid, String slotTitle, Integer ruleFlag, boolean isLeaf) {
        this.key = key;
        this.parentUuid = parentUuid;
        this.ruleFlag = ruleFlag;
        this.slotTitle = slotTitle;
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "hasDatarule");
        this.scopedSlots = map;
        this.isLeaf = isLeaf;
        this.value = key;
        if (!isLeaf) {
			this.children = new ArrayList<TreeDto>();
		}
	}
}
