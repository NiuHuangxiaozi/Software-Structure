
package asciiPanel;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
public class AsciiConfig_2 
{
    @Bean
    public AsciiPanel  asciiPanel()
    {
        return new AsciiPanel();
    }
    
    @Bean
    public AsciiFont font()
    {
        return new AsciiFont("cp437_9x16.png",10,10);
    }
    @Bean
    public String fontFilename()
    {
        return "taffer_10x10.png";
    }

    @Bean
    public int width()
    {
        return 10;
    }

    @Bean
    public int height()
    {
        return 10;
    }
}
