package com.zacboot.admin.mapper.provider;

import com.zac.system.core.entity.admin.SysRolePermission;
import com.zacboot.admin.beans.example.SysRolePermissionExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysRolePermissionSqlProvider {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    public String countByExample(SysRolePermissionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_role_permission");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    public String deleteByExample(SysRolePermissionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_role_permission");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    public String insertSelective(SysRolePermission record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role_permission");
        
        if (record.getRoleUuid() != null) {
            sql.VALUES("role_uuid", "#{roleUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getPermissionUuid() != null) {
            sql.VALUES("permission_uuid", "#{permissionUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    public String selectByExample(SysRolePermissionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("role_uuid");
        } else {
            sql.SELECT("role_uuid");
        }
        sql.SELECT("permission_uuid");
        sql.SELECT("uuid");
        sql.SELECT("create_user");
        sql.SELECT("create_time");
        sql.SELECT("update_user");
        sql.SELECT("update_time");
        sql.SELECT("deleted");
        sql.FROM("sys_role_permission");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysRolePermission record = (SysRolePermission) parameter.get("record");
        SysRolePermissionExample example = (SysRolePermissionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_role_permission");
        
        if (record.getRoleUuid() != null) {
            sql.SET("role_uuid = #{record.roleUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getPermissionUuid() != null) {
            sql.SET("permission_uuid = #{record.permissionUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role_permission");
        
        sql.SET("role_uuid = #{record.roleUuid,jdbcType=VARCHAR}");
        sql.SET("permission_uuid = #{record.permissionUuid,jdbcType=VARCHAR}");
        sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
        
        SysRolePermissionExample example = (SysRolePermissionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_role_permission
     *
     * @mbg.generated Thu Nov 03 22:07:28 CST 2022
     */
    protected void applyWhere(SQL sql, SysRolePermissionExample example, boolean includeExamplePhrase) {
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
        List<SysRolePermissionExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            SysRolePermissionExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<SysRolePermissionExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    SysRolePermissionExample.Criterion criterion = criterions.get(j);
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