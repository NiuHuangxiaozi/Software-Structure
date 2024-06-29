package asciiPanel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class Main
{
    public static void main(String[] args) {
          
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AsciiConfig.class);
        AsciiPanel mypanel = context.getBean(AsciiPanel.class);
        System.out.println(mypanel.getAsciiFont().getFontFilename());
        System.err.println(mypanel.getAsciiFont().getWidth()+" "+mypanel.getAsciiFont().getHeight());

        context.close();

        AnnotationConfigApplicationContext context_2=new AnnotationConfigApplicationContext(AsciiConfig_2.class);
        AsciiPanel my_next_panel = context_2.getBean(AsciiPanel.class);
        System.out.println(my_next_panel.getAsciiFont().getFontFilename());
        System.err.println(my_next_panel.getAsciiFont().getWidth()+" "+my_next_panel.getAsciiFont().getHeight());

        context_2.close();

    }
}