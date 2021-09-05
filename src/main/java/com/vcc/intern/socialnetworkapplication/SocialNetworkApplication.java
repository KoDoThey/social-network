package com.vcc.intern.socialnetworkapplication;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Quản lý đăng nhập đăng xuất user
 * User có thể đăng bài post đơn giản chỉ có text
 * Các thông tin quản lý qua mysql
 *
 * User có các chức năng:
 * Đăng bài viết
 * Like bài viết mới
 * Like một user khác
 * 2 User cùng like nhau thì match
 *
 * Cần có các api:
 * - List post của user OK (kèm trạng thái đã like hay chưa)
 * - Danh sách các user mà mình đã like
 * - Danh sách các user đã match
 * - Tạo, sửa, xóa bài viết của mình OK
 * - Like bài viết của user khác OK
 * - Like một user khác OK
 * */

@SpringBootApplication
public class SocialNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkApplication.class, args);

		TableDescriptorBuilder tableBuilder = TableDescriptorBuilder.newBuilder(TableName.valueOf("post1"));
		ColumnFamilyDescriptor colf1 = ColumnFamilyDescriptorBuilder.of(Bytes.toBytes("info"));
		tableBuilder.setColumnFamily(colf1);
		System.out.println("created table");
	}
}
