package dev.brian.com.retrofit2.api;

import dev.brian.com.retrofit2.model.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostService {

    /*We will be making the api call to
    *
    * http://jsonplaceholder.typicode.com/posts
    *
    * */
    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

}
