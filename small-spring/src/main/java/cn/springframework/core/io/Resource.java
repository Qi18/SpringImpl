package cn.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: rich
 * @date: 2023/4/26 12:28
 * @description:
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
