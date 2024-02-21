package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByCategory(Category category);

	List<Post> findByUser(User u);
	
	List<Post> findByTitleContaining(String title);
	

}
