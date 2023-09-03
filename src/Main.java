import Interfaces.FileHandlerInterface;
import Interfaces.PhonebookIOViewInterface;

public class Main {
    public static void main(String[] args) {
        PhonebookIOViewInterface phonebookIOView = new PhonebookIOView();
        FileHandlerInterface fileHandler = new FileHandler();
        PhonebookWorker phonebookWorker = new PhonebookWorker(phonebookIOView, fileHandler);
        phonebookWorker.process();
    }
}
