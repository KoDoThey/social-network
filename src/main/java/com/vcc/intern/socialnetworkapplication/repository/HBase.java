package com.vcc.intern.socialnetworkapplication.repository;

import com.vcc.intern.socialnetworkapplication.model.Post;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class HBase {
    public List<Post> scanPostTable(TableName tableName, Scan scan) throws Exception{
        Configuration conf = HBaseConfiguration.create();
        List<Post> postList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(tableName))
        {
            ResultScanner scanner = table.getScanner(scan);
            for (Result result = scanner.next(); result != null; result = scanner.next()){


                String  row_key = Bytes.toString(result.getRow());
                String content = Bytes.toString(result.getValue(Bytes.toBytes("post"), Bytes.toBytes("content")));
                String user_id = Bytes.toString(result.getValue(Bytes.toBytes("post"), Bytes.toBytes("user_id")));
                int is_deleted = Bytes.toInt(result.getValue(Bytes.toBytes("post"), Bytes.toBytes("is_deleted")));

                Post post = new Post(row_key, content, user_id, is_deleted);
                postList.add(post);

            }
            scanner.close();
        }
        return postList;
    }

    public void UpdateData(TableName tableName, Put put) throws Exception{
        Configuration conf = HBaseConfiguration.create();

        Connection connection = ConnectionFactory.createConnection(conf);

        Table table = connection.getTable(tableName);

        table.put(put);

        table.close();
    }
}
