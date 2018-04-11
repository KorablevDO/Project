package ProjectServer;

public class RunServer {
    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(new Class<?>[] {Application.class, DataConfig.class}, args);
        for(int i = 0; i < 1000000; i++){
            System.out.println("Что-то делается №" + i);
            Thread.sleep(1000L);
        }
    }
}
