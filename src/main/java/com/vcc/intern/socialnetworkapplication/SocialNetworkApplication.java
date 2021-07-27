package com.vcc.intern.socialnetworkapplication;

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
 * - List post của user (kèm trạng thái đã like hay chưa)
 * - Danh sách các user mà mình đã like
 * - Danh sách các user đã match
 * - Tạo, sửa, xóa bài viết của mình
 * - Like bài viết của user khác
 * - Like một user khác
 * */

@SpringBootApplication
public class SocialNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkApplication.class, args);
	}

}
