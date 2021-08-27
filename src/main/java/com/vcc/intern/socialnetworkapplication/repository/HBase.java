package com.vcc.intern.socialnetworkapplication.repository;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBase {
    public void createTable() throws IOException {
//        //Instantiate HBaseAdmin
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();

        TableName table = TableName.valueOf("post");
        HTableDescriptor htd = new HTableDescriptor(table);
        HColumnDescriptor hcd = new HColumnDescriptor("data");
        htd.addFamily(hcd);
        admin.createTable(htd);

//        //creating table descriptor
//        HTableDescriptor table = new HTableDescriptor(TableName.valueOf("post"));
//
//        //creating column family descriptor
//        HColumnDescriptor family = new HColumnDescriptor("column family");
//
//        //adding coloumn family to HTable
//        table.addFamily(family);
///////////////
//        HBaseConfiguration hc = new HBaseConfiguration(new Configuration());
//        HTableDescriptor ht = new HTableDescriptor("post");
//
//        ht.addFamily( new HColumnDescriptor("info"));
//        ht.addFamily( new HColumnDescriptor("password"));
//        HBaseAdmin hba = new HBaseAdmin( hc );
//
//        hba.createTable( ht );
    }
}
