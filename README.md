This Application is a Blog Application where we have different REST APIs using which user can be created and user related operations can be performed like get,update,delete user.A user can create post and comment on the post.We have category to have posts under different categories.A cateory can also be created and have different operations related to it like create,update,delete category.

Download Project,open it in any IDE and run it on http://localhost:8082/swagger-ui

Softwares Needed:
1)IDE
2)MySQL
3)Postman(Optional)

Below are the APIs created:
1)User APIs:
i)createUser-​/api​/users​/addUser
ii)getUser-/api/users/{id}
iii)updateUser-/api/users/{id}
iv)deleteUser-/api/users/{id}
v)getAllusers-/api/users/

2)Category APIs:
i)createCategory-/api/category/createCategory
ii)getCategory-​/api​/category​/{id}
iii)updateCategory-​/api​/category​/{id}
iv)deleteCategory-/api/category/{id}
v)getAllCategories-/api/category/

3)Post APIs:
i)createPost-​/api​/user​/{userId}​/category​/{categoryId}​/posts
ii)getPostBYId-api/posts/{id}
iii)updatePost-/api/posts/{postId}
iv)getAllPosts-/api/posts
v)getPostsBycategory-/api/category/{categoryId}/posts
vi)deletePost-/api/posts/{id}
vii)searchPostByTitle-/api/posts/search/{keyword}

4)Comment API:
i)CreateComment-/api/post/{postId}/comments
ii)DeleteComment-/api/posts/comments/{id}
