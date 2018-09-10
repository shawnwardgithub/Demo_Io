package IO.Files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Path_Files {


    //读取一个文件，映射成一个list
    public static Path getPath(String filepath){
        Path path=Paths.get(filepath);
        try {
            List<String> kk = Files.readAllLines(path,StandardCharsets.ISO_8859_1);
            kk.stream().forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }
    //删除一个文件
    public static void DeletePath(String path){
        Path ss=Paths.get(path);
        try {
            Files.delete(ss);
           // Files.deleteIfExists(ss) 返回true或者false，代表是否删除成功
        }catch (Exception e){
            e.getMessage();
        }
    }


    //获取某个文件或者目录的基本信息
    public static void getDetailInfo(String directionly){
        Path path=Paths.get(directionly);
        //if(Files.isDirectory(path)){
            System.out.println("文件名：" + path.getFileName());
            System.out.println("名称元素的数量：" + path.getNameCount());
            System.out.println("父路径：" + path.getParent());
            System.out.println("根路径：" + path.getRoot());
            System.out.println("是否是绝对路径：" + path.isAbsolute());
            //startsWith()方法的参数既可以是字符串也可以是Path对象
            System.out.println("是否是以为给定的路径D:开始：" + path.startsWith("D:\\") );
            System.out.println("该路径的字符串形式：" + path.toString());
       // }
    }

    //遍历文件夹,带有自定义过滤器
    public static void foreachInfo(String directionly){
        Path path=Paths.get(directionly);
        if(Files.isDirectory(path)){  //是否为文件夹
            try {
                //存放遍历结果
                List<Path> result=new ArrayList<>();
                Files.walkFileTree(path, new findMyWantsFile(result));
                result.stream().forEach(System.out::println);
                System.out.println(result.size());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    //自定义一个文件过滤器
    public static class findMyWantsFile extends SimpleFileVisitor<Path>{
        private List<Path> result;
        public findMyWantsFile(List result){
            this.result=result;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
         //   if(file instanceof Path){
            //    if(file.getFileName().endsWith("dll")){
                    result.add(file);
                    return FileVisitResult.CONTINUE;
            //    }
       //     }
      //      return FileVisitResult.SKIP_SUBTREE;
        }
    }

    //获取
    public void foreachOneDirectly(){

    }
    public static void main(String[] args) {
        //getPath("E:\\software\\165tch.txt");
        //文件夹基本信息
        //getDetailInfo("E:");
        //文件基本信息
       // getDetailInfo("E:\\software\\165tch.txt");
        //遍历文件自定义过滤器的文件夹
        foreachInfo("E:\\software");

    }
}
