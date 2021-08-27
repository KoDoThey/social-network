package com.vcc.intern.socialnetworkapplication.repository;
import com.vcc.intern.socialnetworkapplication.model.Post;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostHBase {
    public void addPostToHbase(Post post) throws Exception {
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);

        Table table = null;

        try {
            table = connection.getTable(TableName.valueOf("post"));
            System.out.println("Table: " + table.toString());

            String row_key = String.valueOf(post.getPostId());

            Put p = new Put(Bytes.toBytes(row_key));

            p.addColumn(Bytes.toBytes("post"),
                    Bytes.toBytes("content"),
                    Bytes.toBytes(post.getContent()));

            p.addColumn(Bytes.toBytes("post"),
                    Bytes.toBytes("user_id"),
                    Bytes.toBytes(post.getUserId()));

//            p.addColumn(Bytes.toBytes("post"),
//                    Bytes.toBytes("create_time"),
//                    Bytes.toBytes(post.getCreateTime()));
//
//            p.addColumn(Bytes.toBytes("post"),
//                    Bytes.toBytes("edit_time"),
//                    Bytes.toBytes(post.getEditTime()));

            p.addColumn(Bytes.toBytes("post"),
                    Bytes.toBytes("is_deleted"),
                    Bytes.toBytes(post.getIsDeleted()));

            table .put(p);
        } finally {
            assert table != null;
            table.close();
            connection.close();
        }
    }

//    public void updatePost(Post post){
//        Put put = new Put(Bytes.toBytes(post.getPostId()));
//        put.addColumn(Bytes.toBytes("post"), Bytes.toBytes("content"), Bytes.toBytes(post.getContent()));
//        put.addColumn(Bytes.toBytes("post"), Bytes.toBytes("edit_time"), Bytes.toBytes(post.getEditTime()));
//        put.addColumn(Bytes.toBytes("post"), Bytes.toBytes("amount"), Bytes.toBytes(book.getAmount()));
//
//        Hbase hbase =new Hbase();
//        hbase.UpdateData(TableName.valueOf("book_lib"), put);
//    }
}
