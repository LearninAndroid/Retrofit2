package dev.brian.com.retrofit2.api;

public class ApiUtils {
    private ApiUtils(){}

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static PostService getApiService(){
        return ApiClient.getClient(BASE_URL).create(PostService.class);
    }
}
