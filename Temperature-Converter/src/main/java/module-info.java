module com.example.temperatuveconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;

    opens com.example.temperatuveconverter to javafx.fxml;
    exports com.example.temperatuveconverter;
}