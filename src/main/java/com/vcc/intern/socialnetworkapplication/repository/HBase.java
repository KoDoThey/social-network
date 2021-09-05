package com.vcc.intern.socialnetworkapplication.repository;

import com.vcc.intern.socialnetworkapplication.model.Post;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class HBase {
    public TableDescriptor createTable(String tableName) throws IOException {

//        Configuration config = HBaseConfiguration.create();
//        Connection conn = ConnectionFactory.createConnection(config);
//        Admin admin = conn.getAdmin();

        TableDescriptorBuilder tableBuilder = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName));
        ColumnFamilyDescriptor colf1 = ColumnFamilyDescriptorBuilder.of(Bytes.toBytes("info"));
        tableBuilder.addColumnFamily(colf1);

//        TableDescriptorBuilder.newBuilder(TableName.valueOf("name"))
//                .setColumnFamily(
//                        ColumnFamilyDescriptorBuilder.newBuilder("a".getBytes())
//                                .build())
//                .build();

        return tableBuilder.build();
    }

    public void dropTable(String tableName) throws IOException {
        Configuration config = HBaseConfiguration.create();
        HBaseAdmin admin = new HBaseAdmin(config);

        admin.disableTable(TableName.valueOf(tableName));

        admin.deleteTable(TableName.valueOf(tableName));
        System.out.println("Table deleted");
    }

    public Boolean checkExists(String tableName) throws IOException {
        Configuration config = HBaseConfiguration.create();
        HBaseAdmin admin = new HBaseAdmin(config);

        boolean bool = admin.tableExists(TableName.valueOf(tableName));
        return bool;
    }

    public List<Post> scanTable(TableName tableName, Scan scan) {
        Configuration config = HBaseConfiguration.create();
        List<Post> postList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.createConnection(config);
             Table table = connection.getTable(tableName)) {
            ResultScanner scanner = HTable.getScanner(scan);

            for (Result result = scanner.next(); result != null; result = scanner.next()) {
                String postId = Bytes.toString(result.getRow());
                String content = Bytes.toString(result.getValue(Bytes.toBytes("post"), Bytes.toBytes("content")));
                String userId = Bytes.toString(result.getValue(Bytes.toBytes("post"), Bytes.toBytes("user_id")));

                scan.addColumn(Bytes.toBytes("info"), Bytes.toBytes("post_id"));
                Post post = new Post(postId, content, userId);
                postList.add(post);

            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postList;
    }


}
