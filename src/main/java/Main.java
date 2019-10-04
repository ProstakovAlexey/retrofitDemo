import client_json.ClientSendJson;

public class Main {

        private Main() { }

        public static void main(final String[] args) {

            /*
            System.out.println("Программа запущена");
            System.out.println("Запускаю получение списка файлов...");
            ClientGetFilesJSON client = new ClientGetFilesJSON();
            client.start();
            */
            System.out.println("Загрузка файла");
            ClientSendJson client1 = new ClientSendJson();
            client1.start();
        }
}
