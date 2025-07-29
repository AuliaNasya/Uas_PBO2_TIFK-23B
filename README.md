# 💊 Aplikasi Apotek - JavaFX

Aplikasi Apotek adalah program desktop sederhana berbasis **JavaFX** dan **MySQL** yang digunakan untuk mengelola data pasien, dokter, resep, obat, dan transaksi. Aplikasi ini dibangun dengan menerapkan prinsip **Object-Oriented Programming (OOP)** secara konsisten.

## 🧩 Fitur Utama

- Input data **Pasien**
- Input data **Dokter**
- Input data **Resep** (terhubung ke Pasien dan Dokter)
- Input data **Obat**
- Input **Transaksi Pembelian** (terhubung ke Resep dan Obat)

Seluruh data disimpan langsung ke **database MySQL** melalui koneksi JDBC.

## 🧠 Penerapan OOP (Object-Oriented Programming)

Aplikasi ini menerapkan empat prinsip dasar OOP:

---

### 1. **Encapsulation (Enkapsulasi)**  
Semua atribut dan operasi tiap entitas (seperti pasien, dokter, dll) disimpan di dalam controller masing-masing. Akses ke elemen UI dikontrol secara ketat menggunakan `private`.

🔹 **Contoh:**
```java
@FXML
private TextField txtId, txtNama;

@FXML
private void simpanPasien() {
    String id = txtId.getText();
    String nama = txtNama.getText();
    // Proses simpan data
}

Link Video Run: 
