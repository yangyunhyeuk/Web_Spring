package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
   public static void main(String[] args) {

      // 1. ������ �����̳ʸ� ���۽��Ѻ���!~~
	  // ������ �θ�, ������ �ڽ�
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
      //  == Look up
      // Test t=(Test)factory.getBean("phone");
     //  t.print();
      Phone phone=(Phone)factory.getBean("phone");
      phone.powerOn();
      phone.volumeUp();      
      // 3. ������ �����̳� ����
      factory.close();
      
      // => Console
      // ���� <bean> ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ���������ϴ�!
      // �⺻ ������ ȣ���!
      
      // => Console
      // �⺻ ������ ȣ���!
      // ���
      
   }
}