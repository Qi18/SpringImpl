package cn.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: rich
 * @date: 2023/4/26 12:36
 * @description:
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }
}
