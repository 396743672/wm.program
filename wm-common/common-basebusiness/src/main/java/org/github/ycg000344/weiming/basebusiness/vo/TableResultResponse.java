/** 
 * Project Name:business-base 
 * File Name:TableResultResponse.java 
 * Package Name:org.github.ycg000344.weiming.businessbase.vo 
 * Date:2018年5月6日下午5:19:42 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.basebusiness.vo;

import java.util.List;

import org.github.ycg000344.weiming.basecommon.vo.BaseResponse;

/** 
 * ClassName:TableResultResponse <br/><br/>  
 * Description: 分页查询返回对象 <br/><br/>  
 * Date:     2018年5月6日 下午5:19:42 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class TableResultResponse<T> extends BaseResponse {
	TableData<T> data;

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<T>(total, rows);
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    @SuppressWarnings("hiding")
	class TableData<T> {
        long total;
        List<T> rows;

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }
    }

}
  