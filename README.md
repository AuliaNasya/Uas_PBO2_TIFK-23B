 💊 Aplikasi Apotek - JavaFX
Aplikasi Apotek adalah program desktop sederhana berbasis JavaFX dan MySQL yang digunakan untuk mengelola data pasien, dokter, resep, obat, dan transaksi. Seluruh data tersimpan langsung ke database MySQL menggunakan koneksi JDBC. Aplikasi ini dirancang dengan pendekatan Object-Oriented Programming (OOP) untuk menjaga struktur kode tetap modular dan mudah dikembangkan.

🧩 Fitur Utama
Input data Pasien

Input data Dokter

Input data Resep (terhubung ke Pasien dan Dokter)

Input data Obat

Input data Transaksi (terhubung ke Resep dan Obat)

🧠 Penerapan OOP (Object-Oriented Programming)
Aplikasi ini mengimplementasikan prinsip dasar OOP sebagai berikut:

1. Encapsulation
Setiap atribut dan logika dikemas dalam class dan hanya diakses melalui method tertentu.

java
Salin
Edit
private TextField txtNama;
public void simpanPasien() { ... }
2. Abstraction
Detail teknis seperti koneksi ke database disembunyikan dari pengguna dan dibungkus dalam class khusus.

java
Salin
Edit
public class Koneksi {
    public static Connection getConnection() { ... }
}
3. Inheritance
Class Pasien dan Dokter mewarisi atribut umum dari superclass Orang.

java
Salin
Edit
class Orang { String nama; }
class Pasien extends Orang { String id; }
class Dokter extends Orang { String spesialis; }
4. Polymorphism
Setiap modul memiliki method simpanData() yang sama namun dengan implementasi yang berbeda sesuai kebutuhan.

java
Salin
Edit
public void simpanData() {
    // Implementasi khusus untuk masing-masing controller
}
🎥 Link Demo
Klik di sini untuk melihat video running aplikasi (ganti dengan link YouTube jika tersedia)
