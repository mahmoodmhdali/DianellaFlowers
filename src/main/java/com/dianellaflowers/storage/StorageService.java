//package com.dianellaflowers.storage;
//
//import org.springframework.core.io.Resource;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.File;
//import java.nio.file.Path;
//import java.util.stream.Stream;
//
//public interface StorageService {
//
//    void init();
//
//    Path getFileSystemStorageService();
//    
//    File store(MultipartFile file, String path, String FileName);
//
//    Stream<Path> loadAll();
//
//    Path load(String filename);
//
//    Resource loadAsResource(String filename);
//
//    void deleteAll();
//
//}
