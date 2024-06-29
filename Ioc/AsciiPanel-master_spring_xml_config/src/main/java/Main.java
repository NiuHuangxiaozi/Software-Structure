

import asciiPanel.AsciiPanel;

import javax.swing.JFrame;

import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main
{
    public static void main(String[] args) 
    {
          
        ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("spring_config.xml");

        AsciiPanel mypanel = context.getBean("panel",AsciiPanel.class);
        System.out.println(mypanel.getAsciiFont().getFontFilename());
        System.err.println(mypanel.getAsciiFont().getWidth()+" "+mypanel.getAsciiFont().getHeight());


        AsciiPanel mypanel_2 = context.getBean("panel_2",AsciiPanel.class);
        System.out.println(mypanel_2.getAsciiFont().getFontFilename());
        System.err.println(mypanel_2.getAsciiFont().getWidth()+" "+mypanel_2.getAsciiFont().getHeight());
        
        mypanel_2.write("Hello, 2024.3.12!");

        JFrame jFrame = new JFrame();
        jFrame.add(mypanel_2);
        jFrame.pack();
        jFrame.setVisible(true);

        context.close();
    }
}