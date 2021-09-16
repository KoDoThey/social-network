package com.vcc.intern.socialnetworkapplication.repository.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

public class FilterScan {

    public void rowsScan(String startRow, String endRow) {
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes(startRow));
        scan.setStopRow(Bytes.toBytes(endRow));
    }


    public void valueScan(String tableName, String colName, String value) {
        Scan scan = new Scan();
        SingleColumnValueFilter filter = new SingleColumnValueFilter(Bytes.toBytes(tableName),
                Bytes.toBytes(colName),
                CompareFilter.CompareOp.EQUAL,
                Bytes.toBytes(value));
        scan.setFilter(filter);
    }


    public void regexScan(String regexString, String tableName, String colName) {
        Scan scan = new Scan();
        RegexStringComparator comparator = new RegexStringComparator(regexString);
        SingleColumnValueFilter filter = new SingleColumnValueFilter(Bytes.toBytes(tableName),
                Bytes.toBytes(colName),
                CompareFilter.CompareOp.EQUAL, comparator);
        scan.setFilter(filter);
    }


    public void rowkeyScan(String rowkey) {
        Scan scan = new Scan();
        scan.setRowPrefixFilter(Bytes.toBytes(rowkey));
    }


    public void rowkeyPaginationScan(String rowkey) {
        Filter filter = new PageFilter(10);
        Scan scan = new Scan();
        scan.setFilter(filter);
        scan.setRowPrefixFilter(Bytes.toBytes(rowkey));
    }


    public void hbase(String tableName){
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf(tableName));
        Filter filter = new PageFilter(10);
        Scan scan = new Scan();
        scan.setFilter(filter);
        ResultScanner scanner = table.getScanner(scan);
        System.out.println("Results of scan:");
        for (Result result : scanner) {
            System.out.println(result);
        }
        scanner.close();
    }
}
