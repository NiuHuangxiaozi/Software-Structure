
package asciiPanel;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
public class AsciiConfig 
{
    @Bean
    public AsciiPanel  asciiPanel()
    {
        return new AsciiPanel();
    }
    
    @Bean
    public AsciiFont font()
    {
        return new AsciiFont("drake_10x10.png",10,10);
    }
    @Bean
    public String cp()
    {
        return "cp437_9x16.png";
    }
    @Bean
    public int width()
    {
        return 9;
    }

    @Bean
    public int height()
    {
        return 16;
    }
}
