package com.example.demo6;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocumentTool {


    public static void addFolder(String folderName){//创建文件夹
        try{
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdCard = Environment.getExternalStorageDirectory();
                File newFolder = new File(sdCard+File.separator+folderName);
                if(!newFolder.exists()){
                    boolean isSuccess = newFolder.mkdirs();
                    Log.i("TAG:","文件夹创建状态："+isSuccess);
                }
                Log.i("TAG:","文件夹所在目录："+newFolder.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addFileText(String folderName){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File sdCard = Environment.getExternalStorageDirectory();
            File newFolder = new File(sdCard+File.separator+folderName);
            String fileName=folderName+".txt";
            Log.i("TAG:","text文件的储存目录："+newFolder.toString());
            File txtFile = new File (newFolder, fileName);//创建于文件夹同名的text文件
            if (!txtFile.exists()) {
                try {
                    FileOutputStream outputStream = new FileOutputStream(txtFile);
                    outputStream.write("你好呀，我们是奥利给组。".getBytes());//写操作
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void exit(){
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
