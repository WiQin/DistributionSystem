package com.vshop.util.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理ResultSet的接口
 * 
 * @author Auger
 * @version 1.0
 * 
 */
public interface IResultSetUtil {
	public Object doHandler(ResultSet rs) throws SQLException;
}
