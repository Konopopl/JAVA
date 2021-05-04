import com.company.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Testo {
    @Test
    public void Testo(){

 Object o= Main.program("C:\\Users\\Pavlo\\IdeaProjects\\Hello_World\\names1.txt");
 if(o instanceof legal  ) { legal l=(legal)o;
     assertEquals(l.name,"ignat");

        }
    }
}


















