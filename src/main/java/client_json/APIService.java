package client_json;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("file/list")
    Call<FilesList> getFiles();
}
