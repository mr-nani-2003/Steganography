
# Java Steganography - Hiding Data in Images

## 📌 Project Overview
This project implements **image-based steganography** using **Least Significant Bit (LSB)** encoding to hide and retrieve secret messages within images. The goal is to provide a secure way of **concealing sensitive data** in images without noticeable changes.

## 🚀 Features
- **Hide text messages** inside an image using LSB encoding.
- **Extract hidden messages** from the image.
- **Graphical User Interface (GUI)** for ease of use.
- **Supports PNG and BMP image formats** (lossless formats to prevent data loss).
- **Password protection** for added security.

## 🛠️ Technologies Used
- **Java** (Core Java for processing)
- **Swing / JavaFX** (For GUI)
- **BufferedImage** (For handling image data)
- **I/O Streams** (For reading/writing image files)

## 📖 How It Works
1. **Encoding (Hiding Data)**
   - The input message is converted into binary.
   - The binary message is embedded into the **least significant bits** of the image pixels.
   - The modified image is saved without visible distortion.

2. **Decoding (Extracting Data)**
   - The program scans the image and extracts the hidden binary data.
   - The binary data is converted back into readable text.

## 🎮 Usage
### 1️⃣ Running the Application
- **Clone the repository**:  
  ```sh
  git clone https://github.com/yourusername/steganography-java.git
  cd steganography-java
