package com.lqjk.admin.mapper.provider;

import com.lqjk.base.bizentity.SysPermission;
import com.lqjk.admin.beans.example.SysPermissionExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysPermissionSqlProvider {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    public String countByExample(SysPermissionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_permission");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    public String deleteByExample(SysPermissionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_permission");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    public String insertSelective(SysPermission record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_permission");
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getParentUuid() != null) {
            sql.VALUES("parent_uuid", "#{parentUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getComponent() != null) {
            sql.VALUES("component", "#{component,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getRedirect() != null) {
            sql.VALUES("redirect", "#{redirect,jdbcType=VARCHAR}");
        }
        
        if (record.getSortNo() != null) {
            sql.VALUES("sort_no", "#{sortNo,jdbcType=INTEGER}");
        }
        
        if (record.getMenuType() != null) {
            sql.VALUES("menu_type", "#{menuType,jdbcType=INTEGER}");
        }
        
        if (record.getHidden() != null) {
            sql.VALUES("hidden", "#{hidden,jdbcType=BIT}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.VALUES("update_user", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleted() != null) {
            sql.VALUES("deleted", "#{deleted,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    public String selectByExample(SysPermissionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uuid");
        } else {
            sql.SELECT("uuid");
        }
        sql.SELECT("parent_uuid");
        sql.SELECT("`name`");
        sql.SELECT("code");
        sql.SELECT("icon");
        sql.SELECT("component");
        sql.SELECT("url");
        sql.SELECT("redirect");
        sql.SELECT("sort_no");
        sql.SELECT("menu_type");
        sql.SELECT("hidden");
        sql.SELECT("create_user");
        sql.SELECT("create_time");
        sql.SELECT("update_user");
        sql.SELECT("update_time");
        sql.SELECT("deleted");
        sql.FROM("sys_permission");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysPermission record = (SysPermission) parameter.get("record");
        SysPermissionExample example = (SysPermissionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_permission");
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getParentUuid() != null) {
            sql.SET("parent_uuid = #{record.parentUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getComponent() != null) {
            sql.SET("component = #{record.component,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getRedirect() != null) {
            sql.SET("redirect = #{record.redirect,jdbcType=VARCHAR}");
        }
        
        if (record.getSortNo() != null) {
            sql.SET("sort_no = #{record.sortNo,jdbcType=INTEGER}");
        }
        
        if (record.getMenuType() != null) {
            sql.SET("menu_type = #{record.menuType,jdbcType=INTEGER}");
        }
        
        if (record.getHidden() != null) {
            sql.SET("hidden = #{record.hidden,jdbcType=BIT}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleted() != null) {
            sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_permission");
        
        sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
        sql.SET("parent_uuid = #{record.parentUuid,jdbcType=VARCHAR}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("component = #{record.component,jdbcType=VARCHAR}");
        sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        sql.SET("redirect = #{record.redirect,jdbcType=VARCHAR}");
        sql.SET("sort_no = #{record.sortNo,jdbcType=INTEGER}");
        sql.SET("menu_type = #{record.menuType,jdbcType=INTEGER}");
        sql.SET("hidden = #{record.hidden,jdbcType=BIT}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
        
        SysPermissionExample example = (SysPermissionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table htx..sys_permission
     *
     * @mbg.generated Sun Dec 11 23:22:23 CST 2022
     */
    protected void applyWhere(SQL sql, SysPermissionExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<SysPermissionExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            SysPermissionExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<SysPermissionExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    SysPermissionExample.Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}