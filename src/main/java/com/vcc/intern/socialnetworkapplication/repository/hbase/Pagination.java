package com.vcc.intern.socialnetworkapplication.repository.hbase;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Pagination {
    protected int numberOfRecords;
    protected String startKey;
    protected int pageNumber;
    protected String scrollingType;

    Filter filter = new PageFilter(10);

//    public void put(String key, Pagination pagination) throws DAOException {
//        HTableInterface table = null;
//        try {
//            table = getTable("PAGINATION");
//            Put put = new Put(Bytes.toBytes(key + "\_" + pagination.getNumberOfRecords()));
//            put.add(Bytes.toBytes("CF"), Bytes.toBytes(pagination.getPrevPageNumber()), Bytes.toBytes(pagination.getStartKey()));
//            put.add(Bytes.toBytes("CF"), Bytes.toBytes("LAST\_ACCESSED"), Bytes.toBytes(System.currentTimeMillis()));
//            table.put(put);
//        } catch (IOException e) {
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw));
//            logger.error(sw.toString());
//            throw new DAOException("Failed to update: " + e.getMessage());
//        } finally {
//            closeResources(table);
//        }
//        logger.info("WSPagination.put: end");
//    }
//
//    public String get(String key, Pagination pagination) throws DAOException {
//        HTableInterface table = null;
//        String resultStr = null;
//        try {
//            table = getTable("PAGINATION");
//            logger.debug("get key:" + key + DatabaseConstants.FIELD\_DELIMITER\_TRANS + pagination.getNumberOfRecords() + "page: " + (pagination.getPrevPageNumber()));
//            Get get = new Get(Bytes.toBytes(key + "\_" + pagination.getNumberOfRecords()));
//            get.addColumn(Bytes.toBytes("CF"), Bytes.toBytes(pagination.getPrevPageNumber()));
//            Result result = table.get(get);
//            resultStr = (result == null || result.isEmpty()) ? null : Bytes.toString(result.getValue(Bytes.toBytes(WS\_PAGINATION.FAMILY), Bytes.toBytes(pagination.getPrevPageNumber())));
//        } catch (Exception e) {
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw));
//            throw new DAOException("Failed to get Number: " + resultStr + "\t error: " + e.getMessage());
//        } finally {
//            closeResources(table);
//        } return resultStr;
//    }
}