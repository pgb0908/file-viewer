package com.gyubong.fileviewer.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class FileInfo {
    private String fileName;
    private Long fileSize;
    private Long LastMoified;

    private File parentFile;
    private String fileDir;

}
