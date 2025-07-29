package com.mycompany.apotek;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResepController {

    @FXML private TextField txtIdResep;
    @FXML private TextField txtIdPasien;
    @FXML private TextField txtIdDokter;
    @FXML private TextField txtTanggal;

    @FXML
    private void simpanResep() {
        try {
            Connection conn = Koneksi.getConnection();
            String query = "INSERT INTO resep (id, pasien_id, dokter_id, tanggal) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, txtIdResep.getText());
            ps.setString(2, txtIdPasien.getText());
            ps.setString(3, txtIdDokter.getText());
            ps.setString(4, txtTanggal.getText());
            ps.executeUpdate();

            showAlert("Berhasil", "Data resep berhasil disimpan!");
            clearForm();
        } catch (Exception e) {
            showAlert("Gagal", "Error: " + e.getMessage());
        }
    }

    @FXML
    private void pindahKeObat() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ObatView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) txtIdResep.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            showAlert("Error", "Gagal pindah halaman: " + e.getMessage());
        }
    }

    private void clearForm() {
        txtIdResep.clear();
        txtIdPasien.clear();
        txtIdDokter.clear();
        txtTanggal.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

