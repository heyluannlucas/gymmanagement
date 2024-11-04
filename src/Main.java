import View.AcademiaView;
import controller.AcademiaController;
import model.Academia;

public class Main {
    public static void main(String[] args) {
        Academia academia = new Academia();
        AcademiaView view = new AcademiaView();
        new AcademiaController(academia, view);

        view.setVisible(true);
    }
}
