package com.example.demo.Services;

import java.io.File;


public interface FilesServices {
 File getFilePath(String modifiedFileName,String path);
 void DeleteFile(long id);
}
