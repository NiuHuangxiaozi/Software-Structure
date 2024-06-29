
package asciiPanel;

import javax.swing.JFrame;

import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main
{
    public static void main(String[] args) 
    {
          
        ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("config-annotation.xml");

        AsciiPanel mypanel = context.getBean(AsciiPanel.class);
        System.out.println(mypanel.getAsciiFont().getFontFilename());
        System.err.println(mypanel.getAsciiFont().getWidth()+" "+mypanel.getAsciiFont().getHeight());

        context.close();
    }
}