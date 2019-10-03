package client_json;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientGetFilesJSON implements Callback<FilesList> {

    public static final String BASE_URL = "http://sensor.ittest-team.ru/";
    static Retrofit retrofit;

    public ClientGetFilesJSON() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public void start() {
        APIService getFilesList =  retrofit.create(APIService.class);
        getFilesList.getFiles().enqueue(this);
    }

    public void onResponse(Call<FilesList> call, Response<FilesList> response) {
        if(response.isSuccessful()) {
            FilesList files = response.body();
            System.out.println("Получен список файлов:");
            System.out.println(files.getFilesString());
        } else {
            System.out.println("Вместо списка файлов пришла ошибка. Код: " + response.code());
            System.out.println("Тело сообщения: " + response.body());
        }
    }

    public void onFailure(Call<FilesList> call, Throwable t) {
        System.out.println("Во время обращения к сервису возникли ошибки");
        System.out.println(t.getMessage());
    }

}
