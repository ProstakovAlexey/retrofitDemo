package client_json;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.io.File;

public interface APIService {
    @GET("file/list")
    Call<FilesList> getFiles();

    @POST("file/upload")
    Call<FilePin> sendFile(@Body Object body);
}

