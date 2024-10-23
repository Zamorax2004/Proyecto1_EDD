package proyecto_edd;

public class File {
    private String fileName;
    private String content;

    public File(String fileName) {
        this.fileName = fileName;
        this.content = "";
    }

    public void write(String data) {
        this.content += data;
    }

    public String read() {
        return this.content;
    }

    public String getFileName() {
        return this.fileName;
    }
}