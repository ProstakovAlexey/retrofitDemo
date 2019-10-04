package client_json;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientSendJson implements Callback<FilePin> {

    public static final String BASE_URL = "http://sensor.ittest-team.ru/";
    static Retrofit retrofit;

    public ClientSendJson() {
        //TODO поменять фабрику на строку
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public void start() {
        APIService service =  retrofit.create(APIService.class);
        service.sendFile(new Demo()).enqueue(this);
    }


    public void onResponse(Call<FilePin> call, Response<FilePin> response) {
        if(response.isSuccessful()) {
            FilePin pin = response.body();
            System.out.println("Файл успешно загружен, пин: " + pin.getPin());
        } else {
            System.out.println("Вместо файла пришла ошибка. Код: " + response.code());
            System.out.println("Тело сообщения: " + response.body());
        }

    }

    public void onFailure(Call<FilePin> call, Throwable t) {
        System.out.println("Во время обращения к сервису возникли ошибки");
        System.out.println(t.getMessage());
    }
}
