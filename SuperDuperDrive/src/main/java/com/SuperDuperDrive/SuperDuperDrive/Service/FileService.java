package com.SuperDuperDrive.SuperDuperDrive.Service;



import com.SuperDuperDrive.SuperDuperDrive.Mapper.FileMapper;
import com.SuperDuperDrive.SuperDuperDrive.Model.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    private FileMapper fileMapper;

    public FileService(FileMapper noteMapper) {
        this.fileMapper = noteMapper;
    }

    public void createFile(File file) throws FileAlreadyExitsException {
        if(this.fileMapper.getFileByFilename(file.getUserid(), file.getFilename()).isEmpty()){
            this.fileMapper.insert(file);
        }else{
            throw new FileAlreadyExitsException();
        }
    }

    public void deleteFile(int fileId){
        this.fileMapper.deleteFile(fileId);
    }

    public List<File> getUserFiles(int userId){
        return this.fileMapper.getFiles(userId);
    }


    public File getFileById(int fileId){
        return this.fileMapper.getFileById(fileId);
    }
}

