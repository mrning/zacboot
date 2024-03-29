package com.zacboot.system.sso.mapper;

import com.zacboot.system.sso.beans.domain.SysLog;
import com.zacboot.system.sso.beans.domain.SysLogExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysLogSqlProvider {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    public String countByExample(SysLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    public String deleteByExample(SysLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    public String insertSelective(SysLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_log");
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getCostTime() != null) {
            sql.VALUES("cost_time", "#{costTime,jdbcType=BIGINT}");
        }
        
        if (record.getIp() != null) {
            sql.VALUES("ip", "#{ip,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestParam() != null) {
            sql.VALUES("request_param", "#{requestParam,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestType() != null) {
            sql.VALUES("request_type", "#{requestType,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestUrl() != null) {
            sql.VALUES("request_url", "#{requestUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.VALUES("`method`", "#{method,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("userid", "#{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLogContent() != null) {
            sql.VALUES("log_content", "#{logContent,jdbcType=VARCHAR}");
        }
        
        if (record.getLogType() != null) {
            sql.VALUES("log_type", "#{logType,jdbcType=INTEGER}");
        }
        
        if (record.getOperateType() != null) {
            sql.VALUES("operate_type", "#{operateType,jdbcType=INTEGER}");
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
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    public String selectByExample(SysLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uuid");
        } else {
            sql.SELECT("uuid");
        }
        sql.SELECT("cost_time");
        sql.SELECT("ip");
        sql.SELECT("request_param");
        sql.SELECT("request_type");
        sql.SELECT("request_url");
        sql.SELECT("`method`");
        sql.SELECT("username");
        sql.SELECT("userid");
        sql.SELECT("log_content");
        sql.SELECT("log_type");
        sql.SELECT("operate_type");
        sql.SELECT("create_user");
        sql.SELECT("create_time");
        sql.SELECT("update_user");
        sql.SELECT("update_time");
        sql.SELECT("deleted");
        sql.FROM("sys_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysLog record = (SysLog) parameter.get("record");
        SysLogExample example = (SysLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_log");
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getCostTime() != null) {
            sql.SET("cost_time = #{record.costTime,jdbcType=BIGINT}");
        }
        
        if (record.getIp() != null) {
            sql.SET("ip = #{record.ip,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestParam() != null) {
            sql.SET("request_param = #{record.requestParam,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestType() != null) {
            sql.SET("request_type = #{record.requestType,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestUrl() != null) {
            sql.SET("request_url = #{record.requestUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.SET("`method` = #{record.method,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.SET("userid = #{record.userid,jdbcType=VARCHAR}");
        }
        
        if (record.getLogContent() != null) {
            sql.SET("log_content = #{record.logContent,jdbcType=VARCHAR}");
        }
        
        if (record.getLogType() != null) {
            sql.SET("log_type = #{record.logType,jdbcType=INTEGER}");
        }
        
        if (record.getOperateType() != null) {
            sql.SET("operate_type = #{record.operateType,jdbcType=INTEGER}");
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
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_log");
        
        sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
        sql.SET("cost_time = #{record.costTime,jdbcType=BIGINT}");
        sql.SET("ip = #{record.ip,jdbcType=VARCHAR}");
        sql.SET("request_param = #{record.requestParam,jdbcType=VARCHAR}");
        sql.SET("request_type = #{record.requestType,jdbcType=VARCHAR}");
        sql.SET("request_url = #{record.requestUrl,jdbcType=VARCHAR}");
        sql.SET("`method` = #{record.method,jdbcType=VARCHAR}");
        sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        sql.SET("userid = #{record.userid,jdbcType=VARCHAR}");
        sql.SET("log_content = #{record.logContent,jdbcType=VARCHAR}");
        sql.SET("log_type = #{record.logType,jdbcType=INTEGER}");
        sql.SET("operate_type = #{record.operateType,jdbcType=INTEGER}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
        
        SysLogExample example = (SysLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zacboot..sys_log
     *
     * @mbg.generated Sat Apr 24 19:05:51 CST 2021
     */
    protected void applyWhere(SQL sql, SysLogExample example, boolean includeExamplePhrase) {
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
        List<SysLogExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            SysLogExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<SysLogExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    SysLogExample.Criterion criterion = criterions.get(j);
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