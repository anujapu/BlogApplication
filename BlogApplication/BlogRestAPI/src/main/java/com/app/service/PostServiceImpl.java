package com.app.service;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.exception.ResourceNotFoundException;
import com.app.payloads.PostDTO;
import com.app.payloads.PostResponse;
import com.app.repo.CategoryRepository;
import com.app.repo.PostRepository;
import com.app.repo.UserRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	private List<PostDTO> collect;
	
	@Override
	public PostDTO createPost(PostDTO postDTO,long userId,long categoryId) {
		
		System.out.println("In createPost service");
		User u=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id", categoryId));
		Post post = this.modelMapper.map(postDTO, Post.class);
		post.setImage("Default.png");
		post.setCreationDate(new Date());
		post.setUser(u);
		post.setCategory(cat);
		Post savedPost=this.postRepository.save(post);
		return this.modelMapper.map(savedPost, PostDTO.class);
	}

	@Override
	public PostDTO UpdatePost(PostDTO postDTO,long id) {
		Post post =this.postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		this.postRepository.save(post);
		return this.modelMapper.map(post, PostDTO.class);
		
	}

	@Override
	public void deletePost(long id) {
		Post post= this.postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id",id));
		this.postRepository.delete(post);
		
	}

	@Override
	public PostDTO getPostByID(long id) {
		Post post = this.postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		return this.modelMapper.map(post, PostDTO.class);
		
	}

	@Override
	public PostResponse getAllPosts(Integer PageNumber,Integer pageSize,String sortBy,String SortType) {
		Sort sort=null;
		if(SortType.equalsIgnoreCase("ascending"))
		{
			sort=Sort.by(sortBy).ascending();
		}
		else
		{
			sort=Sort.by(sortBy).descending();
		}
		Pageable page=PageRequest.of(PageNumber,pageSize,sort);
		Page<Post> pagePost = this.postRepository.findAll(page);
		List<Post> posts = pagePost.getContent();
		List<PostDTO> allPosts= posts.stream().map((post)->this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		PostResponse postResponse=new PostResponse();
		postResponse.setPosts(allPosts);
		postResponse.setPageNumver(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLast(pagePost.isLast());
		return postResponse;
	}

	
	  @Override public List<PostDTO> getPostsByCategory(long categoryId) {
	  
	  Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "id", categoryId));
	  List<Post> posts=this.postRepository.findByCategory(category);
	  return  posts.stream().map((post)->this.modelMapper.map(post,
	  PostDTO.class)).collect(Collectors.toList());
	  
	  }
	 

	@Override
	public List<PostDTO> getPostsByUser(long userId) {
		User u=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<Post> posts=this.postRepository.findByUser(u);
		return posts.stream().map((post)->this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDTO> searchPost(String keyword) {
	
		List<Post> list = this.postRepository.findByTitleContaining(keyword);
		List<PostDTO> postDTOList = list.stream().map((post)->this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		return postDTOList;
	}

}
