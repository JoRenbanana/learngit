import com.idl.javaidl.java_IDL_connect;
public class IdlText {
	 public static void main(String[] args){
  java_IDL_connect idl=new java_IDL_connect();//����Java_IDL_connectionʵ������idl�ļ�
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