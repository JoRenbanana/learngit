import com.idl.javaidl.java_IDL_connect;
public class IdlText {
	 public static void main(String[] args){
  java_IDL_connect idl=new java_IDL_connect();//利用Java_IDL_connection实现链接idl文件
  System.out.println("idl.createObject");
  idl.createObject();
  System.out.println("idl.excuting compile");
  idl.executeString(".compile -v 'D://IDLWorkspace80//image_enhance//histogram_stretch.pro");
  System.out.println("executing....");
  idl.executeString("STRETCH_DOIT");
  idl.destroyObject();
  System.out.println("success");
}
}